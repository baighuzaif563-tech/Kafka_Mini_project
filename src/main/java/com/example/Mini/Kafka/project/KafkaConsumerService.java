package com.example.Mini.Kafka.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "my-first-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void receiveMessage(String message) {
        logger.info("Received message from Kafka: {}", message);
    }
}
