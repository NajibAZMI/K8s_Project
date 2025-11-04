# Étape 1 : construire l'application
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copier les fichiers pom et sources
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src

# Construire le jar
RUN mvn clean package -DskipTests

# Étape 2 : créer l'image runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copier le jar depuis l'étape précédente
COPY --from=build /app/target/*.jar app.jar

# Exposer le port Eureka
EXPOSE 8761

# Lancer le serveur Eureka
ENTRYPOINT ["java", "-jar", "app.jar"]

