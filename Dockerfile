FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar ./
CMD java -jar *.jar