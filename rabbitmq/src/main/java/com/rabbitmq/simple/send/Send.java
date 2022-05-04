package com.rabbitmq.simple.send;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @Author: golf
 * @Date: 2022/5/2 17:54
 */
@Slf4j
public class Send {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置主机地址
        factory.setHost("118.190.211.69");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("123456");
        factory.setVirtualHost("/test");
        // 创建连接
        try (Connection connection = factory.newConnection();
             // 创建信道
             Channel channel = connection.createChannel()) {
            // 绑定队列 队列名称 持久化 排他队列(基于首次创建的链接可见 其他链接不能创建同名的排他队列 链接关闭排他队列自动删除)
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "这是条生产者消息2";
            // 发送消息
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            log.info("生产者发送消息到队列{},消息内容为:{}", QUEUE_NAME, message);
        }
    }
}
