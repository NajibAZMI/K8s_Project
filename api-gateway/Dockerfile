# Étape 1 : Build
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le code source
COPY src ./src

# Build (sans tests)
RUN mvn clean package -DskipTests

# Étape 2 : Runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copier le JAR depuis le stage de build
COPY --from=build /app/target/ApiGateway-*.jar app.jar

# Exposer le port 8080
EXPOSE 8080

# Démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]