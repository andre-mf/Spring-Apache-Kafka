package com.example.kafka.service;

import com.example.kafka.common.AppConstants;
import com.example.kafka.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendPersonToKafka(Person person) {
        log.info(String.format("Person created -> %s", person));
        this.kafkaTemplate.send(AppConstants.TOPIC_NAME_PERSON, person);
    }
}
