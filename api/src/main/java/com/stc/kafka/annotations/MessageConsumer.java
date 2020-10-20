package com.stc.kafka.annotations;

import java.lang.annotation.*;

/**
 * <p>
 * 用于消费者消费之后的处理
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/21
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageConsumer {

}
