FROM eclipse-temurin:17-jdk AS build
WORKDIR /opt/render/project/src

RUN apt-get update && apt-get install -y maven

COPY .. .

RUN echo "=== Conteúdo do diretório atual ===" && pwd && ls -la
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /opt/render/project/src/target/quarkus-app/lib/ /app/lib/
COPY --from=build /opt/render/project/src/target/quarkus-app/*.jar /app/
COPY --from=build /opt/render/project/src/target/quarkus-app/app/ /app/app/
COPY --from=build /opt/render/project/src/target/quarkus-app/quarkus/ /app/quarkus/

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/quarkus-run.jar"]
