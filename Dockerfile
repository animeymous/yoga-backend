# Use an official lightweight OpenJDK 22 runtime image
FROM eclipse-temurin:22-jdk-alpine

# Create a volume for temporary files
VOLUME /tmp

# Copy the jar built by Maven into the container
COPY target/*.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
