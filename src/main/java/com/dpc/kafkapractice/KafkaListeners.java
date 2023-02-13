package com.dpc.kafkapractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(
            topics = "greetings",
            groupId = "groupId"
    )
    public void greetingListener(String greeting) {
        LOGGER.info("-------------------------------------");
        LOGGER.info("This is a greeting: {}", greeting);
        LOGGER.info("-------------------------------------");
    }
}
