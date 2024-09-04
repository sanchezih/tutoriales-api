FROM openjdk:21-slim

# Establece el directorio de trabajo en /app
WORKDIR /app


# Copia el archivo JAR generado en la carpeta /app dentro del contenedor
COPY target/tutoriales-api-1.0.0.jar app.jar

# Expone el puerto en el que la aplicación Spring Boot escucha (normalmente 8080)
EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]