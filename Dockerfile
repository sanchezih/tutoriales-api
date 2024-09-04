# Usa una imagen base de Maven con OpenJDK 21 para construir la aplicación
FROM maven:3.8.6-openjdk-17 AS build
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