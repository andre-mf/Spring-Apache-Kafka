package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${person.topic.name}")
    private String personTopicName;

    @Bean
    public NewTopic personTopic() {
        return TopicBuilder.name(personTopicName)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
