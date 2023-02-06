FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]
#CMD cd app/kafka_2.13-3.3.1 bin/zookeeper-server-start.sh config/zookeeper.properties

# how to fix it? zookeeper and kafka server is not running, how to?