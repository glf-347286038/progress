package com.rabbitmq.simple.receiver;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @Author: golf  接收
 * @Date: 2022/5/2 20:12
 */
@Slf4j
public class Receiver {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("118.190.211.69");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("123456");
        factory.setVirtualHost("/test");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // 绑定队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            log.info("准备接收消息");
            // 打印消息
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                log.info(QUEUE_NAME + "队列中消息为:{}", message);
            };
            // 消费消息 队列名称 自动确认
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        }
    }
}
