package com.rabbitmq.direct.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: golf
 * @Date: 2022/5/4 23:59
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "direct.email.queue"),
        exchange = @Exchange(value = "direct_test_exchange", type = ExchangeTypes.DIRECT)))
public class EmailDirectConsumer {
    @RabbitHandler
    public void emailDirectConsumer(String message) {
        log.info("emailDirectConsumer接收到消息:{},开始处理消息", message);
    }
}
