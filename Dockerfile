# Use Ubuntu as the base image
FROM ubuntu:18.04 AS base

# Install JDK 8, wget, and MySQL 9.0.0 dependencies
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

# Set the working directory to Tomcat's webapps directory
WORKDIR /opt/tomcat/webapps

# Copy your J2EE project files to the Tomcat webapps directory
COPY . .

# Expose the Tomcat port
EXPOSE 8080

# Start MySQL service and run the SQL script to create the database
RUN service mysql start && \
    mysql -u root -e "CREATE DATABASE IF NOT EXISTS evm_db;" && \
    mysql -u root evm_db < /opt/tomcat/webapps/evmsql.sql

# Start Tomcat server
CMD ["catalina.sh", "run"]
