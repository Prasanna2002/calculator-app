# Use a lightweight JDK 17 runtime
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the container
# Note: The JAR name must match what Maven produces
COPY target/calculator-app-1.0-SNAPSHOT.jar calculator.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "calculator.jar"]