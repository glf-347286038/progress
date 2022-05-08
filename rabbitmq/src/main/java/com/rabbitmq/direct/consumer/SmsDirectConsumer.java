package com.rabbitmq.direct.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @Author: golf
 * @Date: 2022/5/4 23:59
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "direct.sms.queue"),
        exchange = @Exchange(value = "direct_test_exchange")))
public class SmsDirectConsumer {
    @RabbitHandler
    public void smsDirectConsumer(String message) {
        // 消费端出错，broker会一直重试，如果不做限制会出现死循环
        Assert.isTrue(message.length() > 3, "消息长度小于3,消费者报错");
        log.info("smsDirectConsumer接收到消息:{},开始处理消息", message);
    }
}
