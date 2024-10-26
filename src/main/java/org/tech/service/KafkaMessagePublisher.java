package org.tech.service;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;

    @Value("${kafka.producer.topic}")
    private String topic;

    public void sendMessage(String message){
        /**
         * We need to first create a topic from command prompt or we can have some portal where the topic is automatically get created
         * then we can give the name here.
         */
//        CompletableFuture<SendResult<String,Object>> future = template.send(topic, message);
        CompletableFuture<SendResult<String,Object>> future = template.send("programmatically_created_topic", message);
        future.whenComplete((result,ex)->{
            if(ex==null) {
                System.out.println("Sent message=[" + message + " to parition : "+ result.getRecordMetadata().partition() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else{
                System.out.println("Unable to send message=["+message+"] due to : "+ex.getMessage());
            }
        });
    }
}
