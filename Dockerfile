# Use OpenJDK base image
FROM openjdk:21-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file from the correct location
COPY build/libs/book-management-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the app
CMD ["java", "-jar", "app.jar"]
