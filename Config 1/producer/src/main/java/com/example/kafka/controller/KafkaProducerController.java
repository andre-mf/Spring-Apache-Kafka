package com.example.kafka.controller;

import com.example.kafka.model.Person;
import com.example.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping(value = "/createPerson")
    public void sendPersonToKafkaTopic(@RequestBody Person person) {
        this.producerService.sendPersonToKafka(person);
    }
}
