# Use Ubuntu as the base image
FROM ubuntu:20.04

# Set environment variables for non-interactive installation
ENV DEBIAN_FRONTEND=noninteractive
ENV MYSQL_ROOT_PASSWORD=root

# Install JDK 8, Tomcat 7.0.42, and MySQL 8.x
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk wget mysql-server && \
    wget https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.42/bin/apache-tomcat-7.0.42.tar.gz && \
    tar -xvzf apache-tomcat-7.0.42.tar.gz && \
    mv apache-tomcat-7.0.42 /opt/tomcat && \
    rm apache-tomcat-7.0.42.tar.gz

# Set environment variables for Tomcat and MySQL
ENV CATALINA_HOME /opt/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH

# Remove default Tomcat applications
RUN rm -rf $CATALINA_HOME/webapps/ROOT && \
    rm -rf $CATALINA_HOME/webapps/examples && \
    rm -rf $CATALINA_HOME/webapps/docs && \
    rm -rf $CATALINA_HOME/webapps/manager

# Copy your WAR file as ROOT.war for deployment at the root context
COPY bbbbb.war $CATALINA_HOME/webapps/ROOT.war

# Copy your SQL script to the container
COPY evmsql.sql /docker-entrypoint-initdb.d/evmsql.sql

# Expose ports for Tomcat and MySQL
EXPOSE 8080 3306

# Start MySQL, run the SQL script, and start Tomcat
CMD service mysql start && \
    mysql -u root -proot -e "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';" && \
    mysql -u root -proot -e "source /docker-entrypoint-initdb.d/evmsql.sql" && \
    $CATALINA_HOME/bin/catalina.sh run
