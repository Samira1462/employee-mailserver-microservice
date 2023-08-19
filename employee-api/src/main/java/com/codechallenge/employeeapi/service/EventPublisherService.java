package com.codechallenge.employeeapi.service;

import com.codechallenge.employeeapi.model.EmployeeMessage;
import com.codechallenge.employeeapi.util.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Slf4j
@Service
public class EventPublisherService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topic;

    @Autowired
    public EventPublisherService(KafkaTemplate<String, Serializable> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEmployeeEvent(EmployeeMessage message) {

        kafkaTemplate.send(topic, message);

/*        String serializedMessage = JsonUtils.convertEmployeeMessageToJson(message);
        kafkaTemplate.send(topic, serializedMessage);*/

        log.info("message sent: {}", message);
    }

}
