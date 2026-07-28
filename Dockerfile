FROM maven:3.9.7-eclipse-temurin-21 as BUILD
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8000

RUN addgroup -S app && adduser -S app -G app
USER app

ENTRYPOINT ["-jar", "java", "app.jar"]