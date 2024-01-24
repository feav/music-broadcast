
# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -Dspring.profiles.active=prod

# Stage 2: Create the final image with the built JAR
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY --from=build /app/target/distribution-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application will run on (adjust if needed)
EXPOSE 9091

# Specify the command to run your application
CMD ["java", "-jar","-Xdebug",  "-Dspring.profiles.active=prod" ,"/app/app.jar"]
