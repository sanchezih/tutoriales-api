# Etapa de construcción: usa una imagen base de Maven con OpenJDK 17
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app

# Copia el archivo de construcción de Maven y el código fuente
COPY pom.xml ./
COPY src ./src

# Construye la aplicación
RUN mvn clean package -DskipTests

# Etapa de ejecución: usa una imagen base de OpenJDK 21 con slim
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/myapp.jar app.jar

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]