FROM eclipse-temurin:17-jdk AS build
WORKDIR /opt/render/project/src

RUN apt-get update && apt-get install -y maven

COPY . .

RUN echo "=== Conteúdo do diretório atual ===" && pwd && ls -la

RUN mvn clean package -DskipTests
