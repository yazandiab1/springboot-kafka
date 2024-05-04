package com.yazan.kafka_project.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "exalt", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info(String.format("Messaged Recived -> %s", message));
    }

}
