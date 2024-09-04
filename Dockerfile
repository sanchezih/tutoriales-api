FROM openjdk:21

WORKDIR /app

COPY /target/tutoriales-api-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]