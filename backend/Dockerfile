# Use the official Tomcat image as a parent image
FROM tomcat:10.1-jdk17

# Set the working directory in the container
WORKDIR /usr/local/tomcat/webapps/

# Copy the application's WAR file to the Tomcat webapps directory
COPY target/java-build/*.war ROOT.war

# Expose the port the application runs on
EXPOSE 8080

# Tomcat's default CMD will start the server, so no need to override it