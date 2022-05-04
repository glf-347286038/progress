package com.rabbitmq.fanout.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: golf
 * @Date: 2022/5/3 0:07
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.email.queue"),
        exchange = @Exchange(value = "fanout_test_exchange", type = ExchangeTypes.FANOUT)))
public class EmailService {
    @RabbitHandler
    public void emailService(String message) {
        log.info("email开始发送消息:{}", message);
    }
}
