FROM eclipse-temurin:17-jdk AS build
WORKDIR /opt/render/project

RUN apt-get update && apt-get install -y maven

COPY pom.xml ./
COPY src ./src


RUN mvn -f pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /opt/render/project/target/quarkus-app/lib/ /app/lib/
COPY --from=build /opt/render/project/target/quarkus-app/*.jar /app/
COPY --from=build /opt/render/project/target/quarkus-app/app/ /app/app/
COPY --from=build /opt/render/project/target/quarkus-app/quarkus/ /app/quarkus/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/quarkus-run.jar"]
