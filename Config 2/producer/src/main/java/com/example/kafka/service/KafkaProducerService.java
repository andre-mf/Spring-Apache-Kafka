package com.example.kafka.service;

import com.example.kafka.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class KafkaProducerService {

    @Value(value = "${person.topic.name}")
    private String personTopicName;

    @Autowired
    private KafkaTemplate<String, Person> personKafkaTemplate;

    public void sendPersonToKafkaTopic(Person person) {
        ListenableFuture<SendResult<String, Person>> future
                = this.personKafkaTemplate.send(personTopicName, person);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Person>>() {
            @Override
            public void onSuccess(SendResult<String, Person> result) {
                log.info("Person created: "
                        + person + " with offset: " + result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Person created : " + person, ex);
            }
        });
    }
}
