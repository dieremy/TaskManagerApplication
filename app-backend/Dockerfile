##
## Stage 1: Build with maven
##
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

##
## Stage 2: Runner image openjdk:17
##
FROM openjdk:17-slim AS runner

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
