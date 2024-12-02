FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/EmailSender-0.0.1-SNAPSHOT.jar /app/EmailSender-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/EmailSender-0.0.1-SNAPSHOT.jar"]
