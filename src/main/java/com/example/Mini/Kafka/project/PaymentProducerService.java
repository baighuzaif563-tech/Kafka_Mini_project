package com.example.Mini.Kafka.project;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentCreated(String message) {
        kafkaTemplate.send("payment-created", message);
    }
}
