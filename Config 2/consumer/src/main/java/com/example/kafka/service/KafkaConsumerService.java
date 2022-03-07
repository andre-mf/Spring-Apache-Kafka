package com.example.kafka.service;

import com.example.kafka.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "${person.topic.name}", groupId = "${person.topic.group.id}", containerFactory = "personKafkaListenerContainerFactory")
    public void consumer(Person person) {
        log.info(String.format("Person created -> %s", person));
    }
}