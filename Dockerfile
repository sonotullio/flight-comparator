# Usa un'immagine base di Amazon Corretto JDK 21
FROM maven:3-amazoncorretto-21 as builder

# Imposta la working directory
WORKDIR /app

# Copia il file pom.xml e scarica le dipendenze Maven per velocizzare la build
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copia tutto il codice sorgente e compila il progetto
COPY src ./src
RUN mvn clean package -DskipTests

# Secondo stage: runtime leggero con Amazon Corretto JRE 21
FROM amazoncorretto:21

# Imposta la working directory
WORKDIR /app

# Copia il JAR generato nello stage precedente
COPY --from=builder /app/target/*.jar app.jar

# Espone la porta 8080
EXPOSE 8080

# Comando di avvio del container
ENTRYPOINT ["java", "-jar", "app.jar"]
