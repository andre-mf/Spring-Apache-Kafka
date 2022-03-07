package com.example.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PersonProducer {

    @Value("${person.topic}")
    private String personTopic;

    private final KafkaTemplate kafkaTemplate;

    public PersonProducer(final KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPersonToKafkaTopic(final String person) {
        final String messageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(personTopic, messageKey, person);
    }
}