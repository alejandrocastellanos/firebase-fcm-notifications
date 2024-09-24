FROM openjdk:17-jdk-slim

WORKDIR /app

ADD ./target/push-notification-0.0.1-SNAPSHOT.jar app.jar

COPY google_auth_credentials.json .

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
