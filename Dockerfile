FROM maven:3.8.6-eclipse-temurin-17 AS build 
WORKDIR /app
COPY . .
RUN mvn clean package
EXPOSE 8080
CMD ["java", "-jar", "target/*.jar"]