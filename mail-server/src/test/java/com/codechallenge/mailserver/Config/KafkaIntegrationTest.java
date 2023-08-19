/*
package com.codechallenge.mailserver.Config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EmbeddedKafka(topics = "employee-topic", partitions = 1)
public class KafkaIntegrationTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void testSendMessage() throws Exception {
        String topic = "employee-topic";
        String message = "Hello, Kafka!";

        kafkaTemplate.send(topic, message);
        kafkaTemplate.flush();

        ConsumerRecords<String, String> records = KafkaTestUtils.getRecords(consumer, 10000);
        assertEquals(1, records.count());

        ConsumerRecord<String, String> received = records.iterator().next();
        assertEquals(message, received.value());
    }
}
*/






