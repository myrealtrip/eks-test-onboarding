package com.myrealtrip.skeleton.infrastructure.mq;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * MessageQueueAgent
 *
 * @author sarasu
 * @since 2021.10.25
 */
@AllArgsConstructor
@Component
public class MessageQueueAgent {
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String payload) {
        this.kafkaTemplate.send(topic, payload);
    }

    public void sendMessageWithCallback(String topic, String payload, ListenableFutureCallback<SendResult<String, String>> callback) {
        ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send(topic, payload);
        future.addCallback(callback);
    }
}
