package com.example.Mini.Kafka.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumerService.class);

    @KafkaListener(topics = "order-created", groupId = "order-service")
    public void receiveOrderCreated(String message) {
        logger.info("Order Service received order-created event: {}", message);
    }
}
