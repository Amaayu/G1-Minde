# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY ./mvnw ./mvnw
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the project source
COPY . .

# Package the application
RUN ./mvnw package

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/your-application-name.jar"]
