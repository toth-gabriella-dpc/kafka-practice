package com.dpc.kafkapractice3.config;

import com.dpc.kafkapractice3.entity.Greeting;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    // 1. To create message, we need to configure ProducerFactory
    // This sets the strategy for creating Kafka Producer instances.
    @Bean
    public ProducerFactory<String, Greeting> greetingProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();

        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        // for multi-method listeners
        // we have to configure the JSON type mapping
//        configProps.put(JsonSerializer.TYPE_MAPPINGS,
//                "greetings:com.dpc.kafkapractice3.entity.Greeting, farewell:com.dpc.kafkapractice3.entity.Farewell");

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    // 2. KafkaTemplate will wrap the Producer instance and
    // provides convenience methods for sending messages to Kafka topics

    @Bean
    public KafkaTemplate<String, Greeting> greetingKafkaTemplate() {
        return new KafkaTemplate<>(greetingProducerFactory());
    }

}
