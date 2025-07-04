FROM maven:3.9.6-eclipse-temurin-17 as build

WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /app/target/jdbc-docker-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

CMD ["java", "-jar", "app.jar"]