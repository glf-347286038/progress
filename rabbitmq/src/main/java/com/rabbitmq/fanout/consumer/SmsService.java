package com.rabbitmq.fanout.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: golf
 * @Date: 2022/5/3 0:13
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "fanout.sms.queue"),
        exchange = @Exchange(value = "fanout_test_exchange", type = ExchangeTypes.FANOUT)))
public class SmsService {
    @RabbitHandler
    public void messageService(String message) {
        log.info("sms开始发送消息,消息内容:{}", message);
    }
}
