FROM openjdk:11-jdk-slim
LABEL maintainer=jasonwei

COPY target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]