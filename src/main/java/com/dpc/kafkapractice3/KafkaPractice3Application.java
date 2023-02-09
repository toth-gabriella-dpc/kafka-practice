package com.dpc.kafkapractice3;

import com.dpc.kafkapractice3.entity.Greeting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaPractice3Application {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPractice3Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Greeting> kafkaTemplate) {
        return args -> {
            kafkaTemplate.send("greetings", new Greeting("Hello", "World"));
            kafkaTemplate.send("greetings", new Greeting("hi again", "it is me"));
            kafkaTemplate.send("greetings", new Greeting("ciao", "it is me"));
        };
    }
}
