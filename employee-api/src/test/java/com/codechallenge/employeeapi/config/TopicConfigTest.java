package com.codechallenge.employeeapi.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaAdmin;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TopicConfigTest {

    @Autowired
    private KafkaAdmin kafkaAdmin;

    @Autowired
    private NewTopic employeeTopic;

    @Test
    @DisplayName("kafka admin bean should be created")
    public void kafkaAdminBeanShouldBeCreated() {
        assertThat(kafkaAdmin).isNotNull();
    }

    @Test
    @DisplayName("employee topic should be created")
    public void employeeTopicShouldBeCreated() {
        assertThat(employeeTopic).isNotNull();
        assertThat(employeeTopic.name()).isEqualTo("employee-topic");
        assertThat(employeeTopic.numPartitions()).isEqualTo(1);
        assertThat(employeeTopic.replicationFactor()).isEqualTo((short) 1);
    }
}