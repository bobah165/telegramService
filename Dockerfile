FROM openjdk:17.0.1-jdk-slim
COPY build/libs/telegramService-1.0-SNAPSHOT.jar /app/telegramService.jar
EXPOSE 80
CMD ["java", "-jar", "/app/telegramService.jar"]