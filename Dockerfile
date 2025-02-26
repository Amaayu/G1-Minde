# Build stage
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:resolve

# Copy the source code
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17.0.1-jdk-slim

# Copy the jar file from the build stage
COPY --from=build /app/target/G1-Minde-0.0.1-SNAPSHOT.jar G1-Minde.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "G1-Minde.jar"]
