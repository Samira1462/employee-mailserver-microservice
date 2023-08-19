package com.codechallenge.mailserver.Config;

import com.codechallenge.mailserver.model.EmployeeMessage;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest
@DirtiesContext
public class ConsumerConfigTest {

    @Autowired
    private ConsumerFactory<String, EmployeeMessage> consumerFactory;

    @Autowired
    private KafkaListenerContainerFactory<?> kafkaListenerContainerFactory;

    @Test
    public void consumerFactoryConfiguration() {
        assertNotNull(consumerFactory);

        Map<String, Object> props = consumerFactory.getConfigurationProperties();
        assertNotNull(props);

        assertEquals("localhost:9092", props.get(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG));
        assertEquals("employee-group", props.get(ConsumerConfig.GROUP_ID_CONFIG));
    }
}
