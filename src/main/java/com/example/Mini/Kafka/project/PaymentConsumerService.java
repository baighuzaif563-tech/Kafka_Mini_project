package com.example.Mini.Kafka.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentConsumerService.class);

    @KafkaListener(topics = "payment-created", groupId = "payment-service")
    public void receivePaymentCreated(String message) {
        logger.info("Payment Service received payment-created event: {}", message);
    }
}
