package com.rabbitmq.delay;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: golf
 * @Date: 2022/5/6 20:38
 */
@Configuration
public class DelayRabbitMqConfig {
    /**
     * 定义延时消息队列
     *
     * @return 延时队列
     */
    @Bean
    public Queue delayQueue() {
        Map<String, Object> arguments = new HashMap<>(4);
        // 队列中所有的消息60000ms后过期
        arguments.put("x-message-ttl", 6000);
        // 消息过期后进入死信队列
        arguments.put("x-dead-letter-exchange", "direct_delay_dead_exchange");
//        arguments.put("x-dead-letter-routing-key", "delay_dead");
        return new Queue("direct.delay.queue", true, false, false, arguments);
    }

    /**
     * 定义延时交换机
     *
     * @return 延时交换机
     */
    @Bean
    public DirectExchange delayDirectExchange() {
        return new DirectExchange("direct_delay_exchange", true, false);
    }

    /**
     * 绑定延时队列和延时交换机
     *
     * @return 绑定
     */
    @Bean
    public Binding bindingDelay() {
        return BindingBuilder.bind(delayQueue()).to(delayDirectExchange()).with("delay");
    }

    /**
     * 定义延时死信队列
     *
     * @return 死信队列
     */
    @Bean
    public Queue delayDeadQueue() {
        return new Queue("direct.delay.dead.queue", true);
    }

    /**
     * 定义死信交换机
     *
     * @return 死信交换机
     */
    @Bean
    public DirectExchange directDelayDeadExchange() {
        return new DirectExchange("direct_delay_dead_exchange", true, false);
    }

    @Bean
    public Binding bindingDelayDead() {
        return BindingBuilder.bind(delayDeadQueue()).to(directDelayDeadExchange()).with("delay_dead");
    }
}
