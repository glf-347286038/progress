package com.rabbitmq.direct;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Direct模式配置类
 *
 * @Author: golf
 * @Date: 2022/5/4 20:29
 */
@Configuration
public class DirectRabbitMqConfig {

    @Bean
    public Queue emailDirectQueue() {
        return new Queue("direct.email.queue", true);
    }

    @Bean
    public Queue smsDirectQueue() {
        return new Queue("direct.sms.queue", true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_test_exchange", true, false);
    }

    @Bean
    public Binding bindingDirectEmail() {
        return BindingBuilder.bind(emailDirectQueue()).to(directExchange()).with("");
    }

    @Bean
    public Binding bindingDirectSms() {
        return BindingBuilder.bind(smsDirectQueue()).to(directExchange()).with("sms");
    }
}
