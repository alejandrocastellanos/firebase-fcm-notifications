# Use a base image with Java installed
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/push-notification-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 8082

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
