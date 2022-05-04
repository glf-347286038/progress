package com.rabbitmq.direct.producter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: golf
 * @Date: 2022/5/4 20:30
 */
@Slf4j
@RestController
@RequestMapping("/direct")
public class DirectController {
    private static final String EXCHANGE_NAME = "direct_test_exchange";
    private static final String ROUTING_KEY = "";
    private static final String ROUTING_KEY2 = "sms";
    private final RabbitTemplate rabbitTemplate;

    public DirectController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/sendDirectMessage")
    public void sendDirectMessage(@RequestParam("message") String message) {
        // 模拟做业务操作
        log.info("模拟做一些业务操作");
        // 发送消息到消息队列
        // 不指定routing_key,会给所有绑定交换机的队列发送消息
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
        // 指定routingKey,只给指定的队列发送消息
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY2, message);
    }
}
