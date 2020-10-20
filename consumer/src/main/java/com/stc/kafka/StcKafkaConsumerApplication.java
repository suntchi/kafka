package com.stc.kafka;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/7/17
 */
@SpringBootApplication
@EnableDubbo
public class StcKafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StcKafkaConsumerApplication.class, args);
    }

}
