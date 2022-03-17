package com.example.kafka.controller;

import com.example.kafka.PersonProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
@Slf4j
public class PersonController {

    private final PersonProducer personProducer;

    public PersonController(PersonProducer personProducer) {
        this.personProducer = personProducer;
    }

    @PostMapping(value = "/createPerson")
    public void send(@RequestBody String person) {
        personProducer.sendPersonToKafkaTopic(person);
    }
}
