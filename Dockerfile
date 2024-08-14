# Use Ubuntu as the base image
FROM ubuntu:18.04

# Install JDK 8, wget, MySQL 5.7, and required tools
RUN apt-get update && apt-get install -y \
    openjdk-8-jdk \
    wget \
    mysql-server-5.7 \
    mysql-client \
    && wget https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.42/bin/apache-tomcat-7.0.42.tar.gz \
    && tar xvf apache-tomcat-7.0.42.tar.gz \
    && mv apache-tomcat-7.0.42 /opt/tomcat \
    && rm apache-tomcat-7.0.42.tar.gz \
    && mkdir /docker-entrypoint-initdb.d

# Set environment variables for JDK and Tomcat
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV CATALINA_HOME=/opt/tomcat
ENV PATH=$JAVA_HOME/bin:$CATALINA_HOME/bin:$PATH

# Copy the WAR file to Tomcat's webapps directory
COPY bbb.war /opt/tomcat/webapps/ROOT.war

# Copy the SQL script to the Docker image
COPY evmsql.sql /docker-entrypoint-initdb.d/evmsql.sql

# Expose Tomcat port
EXPOSE 8080

# Initialize MySQL and start Tomcat
CMD ["bash", "-c", "\
    service mysql start && \
    sleep 10 && \
    mysql -u root -e \"ALTER USER 'root'@'localhost' IDENTIFIED WITH 'mysql_native_password' BY 'root';\" && \
    mysql -u root -proot -e 'CREATE DATABASE IF NOT EXISTS evm_db;' && \
    mysql -u root -proot evm_db < /docker-entrypoint-initdb.d/evmsql.sql && \
    catalina.sh run"]
