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
//            for (int i = 0; i < 100; i++) {
//                kafkaTemplate.send("random-topic-1", "hello there from kafka producer! " + i );
//            }

            kafkaTemplate.send("random-topic-1", new Greeting("Hello", "World"));
            kafkaTemplate.send("random-topic-1", new Greeting("hi again", "it is me"));
            kafkaTemplate.send("random-topic-1", new Greeting("hi again", "it is me"));
            kafkaTemplate.send("random-topic-1", new Greeting("ciao", "it is me"));
        };
    }
}