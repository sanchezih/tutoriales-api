# Usa una imagen base de Maven para construir la aplicación con Java 21
FROM maven:3.9.0-openjdk-21 AS build
WORKDIR /app

# Copia el archivo de construcción de Maven y el código fuente
COPY pom.xml ./
COPY src ./src

# Construye la aplicación
RUN mvn clean package -DskipTests

# Usa una imagen base de Java 21 con Debian para ejecutar la aplicación
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/myapp.jar app.jar

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]