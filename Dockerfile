# 1. Use a lightweight JDK image
FROM openjdk:17-jdk-slim

# 2. Set working directory inside container
WORKDIR /app

# 3. Copy Maven/Gradle build artifact into container
COPY target/*.jar app.jar

# 4. Expose the port (Render will map this dynamically)
EXPOSE 8080

# 5. Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]
