package org.tech.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * We don't want springboot to decide the configurations of topic,
 * Topic Configurations can be controlled from here.
 */

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("programmatically_created_topic",5,(short)1);
    }
}
