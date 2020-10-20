package com.stc.kafka.provider;

import com.stc.kafka.constant.KafkaTopic;
import com.stc.kafka.utils.KafkaMessageUtils;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * hello kafka
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/7/17
 */
@Component(value = "helloKafka")
public class HelloKafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Resource
    private KafkaMessageUtils kafkaMessageUtils;


    public void sendHelloKafka() {
        ProducerFactory<String, String> producerFactory = buildKafkaTemplate().getProducerFactory();
        buildKafkaTemplate().executeInTransaction(kafkaOperations -> {

            kafkaMessageUtils.sendMessage(kafkaOperations, KafkaTopic.HELLO_KAFKA, KafkaTopic.HELLO_KAFKA, "hello");

            kafkaMessageUtils.sendMessage(kafkaOperations, KafkaTopic.HELLO_KAFKA, KafkaTopic.HELLO_KAFKA, "hello");

            return true;
        });
    }

    private KafkaTemplate<String, String> buildKafkaTemplate(){
        Map<String,Object> config = new HashMap<>(kafkaProperties.buildProducerProperties());
        //设置最大等待发送连接，如果是需要顺序，则需要设置为1
        config.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,1);
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(config));
    }
}
