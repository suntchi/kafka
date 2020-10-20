package com.stc.kafka.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * <p>
 * kafka发送消息的工具类
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/8/4
 */
@Component(value = "kafkaMessageUtils")
@Slf4j
public class KafkaMessageUtils {

    public void sendMessage(KafkaOperations<String,String> kafkaOperations,String topic, String key, String message) {
        // the KafkaTemplate provides asynchronous send methods returning a
        // Future
        ListenableFuture<SendResult<String, String>> future = kafkaOperations.send(topic,key,message);
        // you can register a callback with the listener to receive the result
        // success回调
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                ProducerRecord<String, String> producerRecord = result.getProducerRecord();
                String key = producerRecord.key();
                String value = producerRecord.value();
                RecordMetadata recordMetadata = result.getRecordMetadata();
                String topic = recordMetadata.topic();
                log.info("send kafka message='{}' with offset={}", message, result.getRecordMetadata().offset());
                log.info("key = '{}'" , key);
                log.info("value = '{}'",value);
                log.info("topic = '{}'",topic);
                //TODO 正确信息落地
            }

            @Override
            public void onFailure(Throwable ex) {
                //TODO 错误信息落地
                log.debug("unable to send kafka message='{}'", message, ex);
            }
        });
    }
}
