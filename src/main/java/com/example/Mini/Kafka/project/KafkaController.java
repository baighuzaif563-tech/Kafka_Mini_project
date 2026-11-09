
package com.example.Mini.Kafka.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController 

public class KafkaController {
    private final KafkaProducerService kafkaProducerService;
    private final OrderProducerService orderProducerService;
    private final PaymentProducerService paymentProducerService;

    public KafkaController(
            KafkaProducerService kafkaProducerService,
            OrderProducerService orderProducerService,
            PaymentProducerService paymentProducerService) {
        this.kafkaProducerService = kafkaProducerService;
        this.orderProducerService = orderProducerService;
        this.paymentProducerService = paymentProducerService;
    }

  @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic: " + message);
    }

    @PostMapping("/orders/created")
    public ResponseEntity<String> createOrder(@RequestParam("message") String message) {
        orderProducerService.sendOrderCreated(message);
        return ResponseEntity.ok("Order-created event sent: " + message);
    }

    @PostMapping("/payments/created")
    public ResponseEntity<String> createPayment(@RequestParam("message") String message) {
        paymentProducerService.sendPaymentCreated(message);
        return ResponseEntity.ok("Payment-created event sent: " + message);
    }
}
