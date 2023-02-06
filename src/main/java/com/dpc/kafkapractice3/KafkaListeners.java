package com.dpc.kafkapractice3;

import com.dpc.kafkapractice3.entity.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListeners.class);
    @KafkaListener(
            topics = "random-topic-1",
            groupId = "groupId"
    )
    public void listener(String data) {
        LOGGER.info("Listener received data: {}", data);
    }

    @KafkaListener(
            topics = "topicname",
            containerFactory = "greetingKafkaListenerContainerFactory"
    )
    public void greetingListener(Greeting greeting) {
        LOGGER.info("-------------------------------------");
        LOGGER.info("This is a greeting: {}", greeting);
        LOGGER.info("-------------------------------------");
    }

//    @KafkaListener(
//            topics = "multiTypeTopic"
//    )
//    public void multiTypeListener(Object object) {
//        LOGGER.info("-----------.----.------.----------");
//        LOGGER.info("This is a multiTypeMessage: {}", object.toString());
//        LOGGER.info("-----------.----.------.----------");
//    }
}
