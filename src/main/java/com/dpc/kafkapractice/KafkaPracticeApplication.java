package com.dpc.kafkapractice;

import com.dpc.kafkapractice.model.Greeting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableKafka
public class KafkaPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPracticeApplication.class, args);
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
