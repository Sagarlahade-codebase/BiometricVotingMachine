# Use Ubuntu as the base image
FROM ubuntu:18.04 AS build

# Install JDK 8, wget, MySQL 5.7, and Ant
RUN apt-get update && apt-get install -y \
    openjdk-8-jdk \
    wget \
    mysql-server-5.7 \
    ant

# Download and install Tomcat 7.0.42
RUN wget https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.42/bin/apache-tomcat-7.0.42.tar.gz \
    && tar xvf apache-tomcat-7.0.42.tar.gz \
    && mv apache-tomcat-7.0.42 /opt/tomcat

# Set environment variables for JDK and Tomcat
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV CATALINA_HOME=/opt/tomcat
ENV PATH=$JAVA_HOME/bin:$CATALINA_HOME/bin:$PATH

# Set the working directory to your project root directory
WORKDIR /app

# Copy your project files into the container
COPY . .

# Compile the Java files
RUN mkdir -p /app/WEB-INF/classes
RUN javac -d /app/WEB-INF/classes $(find src/main/java -name "*.java")

# Package the application into a WAR file
RUN mkdir -p /app/WEB-INF/lib
RUN mkdir -p /app/META-INF
RUN cp -r webapps/* /app/
RUN cd /app && jar -cvf /app/your-app-name.war * 

# Deploy the WAR file to Tomcat
FROM ubuntu:18.04 AS final

# Install JDK 8 and Tomcat
RUN apt-get update && apt-get install -y \
    openjdk-8-jdk \
    wget \
    mysql-server-5.7

# Download and install Tomcat 7.0.42
RUN wget https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.42/bin/apache-tomcat-7.0.42.tar.gz \
    && tar xvf apache-tomcat-7.0.42.tar.gz \
    && mv apache-tomcat-7.0.42 /opt/tomcat

# Set environment variables for JDK and Tomcat
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV CATALINA_HOME=/opt/tomcat
ENV PATH=$JAVA_HOME/bin:$CATALINA_HOME/bin:$PATH

# Copy the WAR file to Tomcat's webapps directory
COPY --from=build /app/your-app-name.war /opt/tomcat/webapps/

# Ensure MySQL service is configured with root password
RUN service mysql start && \
    mysql -e "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';"

# Expose the Tomcat port
EXPOSE 8080

# Copy the SQL script to the correct location
COPY evmsql.sql /docker-entrypoint-initdb.d/evmsql.sql

# Start MySQL, initialize the database, and run Tomcat
CMD mysqld_safe --skip-grant-tables & \
    sleep 10 && \
    mysql -u root -proot -e "CREATE DATABASE IF NOT EXISTS evm_db;" && \
    mysql -u root -proot evm_db < /docker-entrypoint-initdb.d/evmsql.sql && \
    catalina.sh run
