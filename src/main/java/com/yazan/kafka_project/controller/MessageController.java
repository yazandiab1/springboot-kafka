package com.yazan.kafka_project.controller;

import com.yazan.kafka_project.kafka.JsonKafkaProducer;
import com.yazan.kafka_project.kafka.KafkaProducer;
import com.yazan.kafka_project.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;
    private JsonKafkaProducer jsonKafkaProducer;


    public MessageController(KafkaProducer kafkaProducer, JsonKafkaProducer jsonKafkaProducer) {
        this.kafkaProducer = kafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage( message );
        return ResponseEntity.ok("Message sent to the topic");
    }

    @GetMapping("/publishJson")
    public ResponseEntity<String> publishJson(@RequestBody User user) {
        jsonKafkaProducer.sendMessage( user );
        return ResponseEntity.ok("Json message sent to the topic");
    }
}
