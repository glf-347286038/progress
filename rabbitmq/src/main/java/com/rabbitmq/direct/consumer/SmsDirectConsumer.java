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
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "direct.sms.queue"),
        exchange = @Exchange(value = "direct_test_exchange", type = ExchangeTypes.DIRECT)))
public class SmsDirectConsumer {
    @RabbitHandler
    public void smsDirectConsumer(String message) throws Exception {
        // 消费端出错，broker会一直重试，如果不做限制会出现死循环
//        if (true) {
//            throw new Exception("故意报错");
//        }
        log.info("smsDirectConsumer接收到消息:{},开始处理消息", message);
    }
}
