package org.producer.config;

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
        return new NewTopic("testing_prducer_config",3,(short)1);
    }
}
