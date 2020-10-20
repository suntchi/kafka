package com.stc.kafka.aops;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jizhang.message.entity.ConsumerEntity;
import com.jizhang.message.entity.ConsumerReceive;
import com.jizhang.message.service.KafkaConsumerService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 消费者消费之后的处理
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/21
 */
@Aspect
@Component(value = "consumerAfterAop")
@Slf4j
public class ConsumerAop {

    final static String DATE_FORMAT = "yyyyMMdd";
    final static DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);


    @Reference
    private KafkaConsumerService kafkaConsumerService;

    @Reference
    private SnowflakeService snowflakeService;

    @Pointcut("@annotation(com.stc.kafka.annotations.MessageConsumer)")
    public void ConsumerAspect(){

    }


    @After("ConsumerAspect()")
    public void doAfterGame(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        ConsumerRecord consumerRecord = null;

        for (Object arg : args) {
            if(arg instanceof ConsumerRecord){
                consumerRecord = (ConsumerRecord) arg;
            }
        }

        for (Object arg : args) {
            if(arg instanceof Consumer){
                Consumer consumer = (Consumer) arg;
                if(Objects.isNull(consumerRecord)){
                    log.info("获取消费记录数据为空");
                }else{
                    ConsumerReceive consumerReceive = new ConsumerReceive(consumerRecord);
                    consumerReceive.setConsumerId(LocalDateTime.now().format(DATETIME_FORMATTER) + snowflakeService.getId(consumerReceive.getConsumerTopic()).getId());
                    kafkaConsumerService.insertConsumer(consumerReceive);
                }
                consumer.commitSync();
            }
        }

    }


    @AfterReturning("ConsumerAspect()")
    public void doAfterReturningGame(){
        log.info("");
    }


    @AfterThrowing("ConsumerAspect()")
    public void doAfterThrowingGame(){
        log.info("");
    }
}
