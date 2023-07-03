package com.myrealtrip.skeleton.domain.sample.kafka;

import com.myrealtrip.skeleton.infrastructure.mq.MessageQueueAgent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Arrays;

/**
 * KafkaSampleService
 *
 * @author sarasu
 * @since 2021.10.25
 */
@Slf4j
@AllArgsConstructor
@Service
public class KafkaSampleService {
    private MessageQueueAgent messageQueueAgent;

    public void sendMessage(String topic, String payload) {
        messageQueueAgent.sendMessage(topic, payload);
    }

    public void sendMessageWithCallback(String topic, String payload) {
        messageQueueAgent.sendMessageWithCallback(topic, payload, new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error(Arrays.toString(ex.getStackTrace()));
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Send message succeeded {}", result);
            }
        });
    }

    @KafkaListener(topics = "topic1", groupId = "group1")
    public void topic1Listener(String payload) {
        log.error("group1 : " + payload);
    }
    @KafkaListener(topics = "topic1", groupId = "group2")
    public void topic1Group2Listener(String payload) {
        log.error("group2 : " + payload);
    }

    @KafkaListener(topics = "topic2", groupId = "group2")
    public void topic2Listener(String payload) {
        log.error( "group2 : " + payload);
    }
}
