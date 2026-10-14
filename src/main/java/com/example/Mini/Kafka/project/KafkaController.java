
package com.example.Mini.Kafka.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController 

public class KafkaController {
    private final KafkaProducerService kafkaProducerService;

    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

  @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic: " + message);
    }
}
