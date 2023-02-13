# Kafka practice application

## How to start this project - in local environment - Docker

1. Open terminal
2. Create .jar file with the following command.

      
      mvn install -Dmaven.test.skip=true

In this "docker-based" scenario, it is important to skip tests.

3. Compose the docker file. This will start the Kafka and Zookeeper microservices and the application as well. The application will run based on the **Dockerfile**. (This is the
   reason, why the maven package was needed to be created.)

   
      docker compose up

4. Change `localhost:9092` to `broker:9092` in _application.properties_ file

---

## Project reference

[Source](https://docs.spring.io/spring-kafka/reference/html/#kafka)


