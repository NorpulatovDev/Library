# Use a base image with Java 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy everything to the container
COPY . .

# Build the project
RUN ./gradlew build

# Run the JAR file
CMD ["java", "-jar", "build/libs/YOUR_APP.jar"]
