package com.stc.kafka.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jizhang.message.entity.ConsumerEntity;
import com.jizhang.message.service.KafkaConsumerService;
import com.stc.kafka.annotations.MessageConsumer;
import com.stc.kafka.constant.KafkaTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>
 * hello kafka消费者
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/7/17
 */
@Component(value = "helloKafkaConsumer")
@Slf4j
public class HelloKafkaConsumer {

    @Autowired
    private KafkaProperties kafkaProperties;


    @Reference
    private KafkaConsumerService kafkaConsumerService;


    @KafkaListener(topics = KafkaTopic.HELLO_KAFKA,groupId = "consumer")
    @MessageConsumer
    public void helloKafka(String message, Consumer<String,String> consumer){
        log.info(message);

    }

    @KafkaListener(topics = "default",groupId = "consumer")
    @MessageConsumer
    public void defaultKafka(Consumer<String,String> consumer, ConsumerRecord<String, String> consumerRecord){
      //执行消费
        log.info("消费");
    }

    @KafkaListener(topics = "test")
    public void testKafka(String message, Consumer<String,String> consumer){
        log.info(message);
        consumer.commitSync();
    }
}
