package com.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: golf
 * @Date: 2022/5/2 23:21
 */
@Configuration
public class DirectRabbitConfig {
    /**
     * 声明email队列
     *
     * @return email队列
     */
    @Bean
    public Queue emailQueue() {
        // durable:是否持久化，默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时依然存在，暂存队列：当前连接有效
        // exclusive：默认false
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除
        // 一般设置队列的持久化就好,其余两个就是false
        return new Queue("email.queue", true);
    }

    /**
     * 声明sms队列
     *
     * @return sms队列
     */
    @Bean
    public Queue smsQueue() {
        return new Queue("sms.queue", true);
    }

    /**
     * 声明微信消息队列
     *
     * @return 微信消息队列
     */
    @Bean
    public Queue weiChatQueue() {
        return new Queue("weiChat.queue", true);
    }

    /**
     * 声明交换机
     *
     * @return 交换机
     */
    @Bean
    public FanoutExchange fanoutOrderExchange() {
        return new FanoutExchange("fanout_order_exchange", true, false);
    }

    /**
     * email队列与交换机进行绑定
     *
     * @return 绑定
     */
    @Bean
    public Binding bingingFanoutEmail() {
        return BindingBuilder.bind(emailQueue()).to(fanoutOrderExchange());
    }

    @Bean
    public Binding bingingFanoutSms() {
        return BindingBuilder.bind(smsQueue()).to(fanoutOrderExchange());
    }

    @Bean
    public Binding bingingFanoutWeiChat() {
        return BindingBuilder.bind(weiChatQueue()).to(fanoutOrderExchange());
    }
}
