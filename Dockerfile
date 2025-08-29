# --------- Build Stage ---------
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven files
COPY pom.xml .
COPY src ./src

# Build the Spring Boot app
RUN mvn clean package -DskipTests

# --------- Run Stage ---------
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy built JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (Render dynamically assigns PORT)
EXPOSE 8083

# Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]
