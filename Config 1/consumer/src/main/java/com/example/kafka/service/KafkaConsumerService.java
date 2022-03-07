package com.example.kafka.service;

import com.example.kafka.common.AppConstants;
import com.example.kafka.model.Person;
import com.example.kafka.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @Autowired
    private PersonRepository repository;

    @KafkaListener(topics = AppConstants.TOPIC_NAME_PERSON, groupId = AppConstants.GROUP_ID)
    public void consumer(Person person) {
        repository.save(person);
        log.info(String.format("Person created -> %s", person));
    }
}
