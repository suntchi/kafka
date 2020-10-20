package com.stc.kafka;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Map;

/**
 * <p>
 * 自定义消费者拦截器
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/8/11
 */
public class MyConsumerInterceptor implements ConsumerInterceptor<String,String> {

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> consumerRecords) {
        consumerRecords.forEach(stringStringConsumerRecord -> {
            System.out.println(stringStringConsumerRecord.value());
        });
        return consumerRecords;
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {
        System.out.println(map);
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println(map);
    }
}
