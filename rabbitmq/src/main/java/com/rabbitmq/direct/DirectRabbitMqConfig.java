package com.rabbitmq.direct;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
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

    /**
     * 定义一个专门存放错误消息的队列
     *
     * @return 队列
     */
    @Bean
    public Queue directErrorQueue() {
        return new Queue("direct.error.queue");
    }

    @Bean
    public DirectExchange directErrorExchange() {
        return new DirectExchange("direct.error.exchange");
    }

    @Bean
    public Binding bindingErrorQueue() {
        return BindingBuilder.bind(directErrorQueue()).to(directErrorExchange()).with("error");
    }

    /**
     * 消费消息时出现异常且重试次数超过配置的次数会将消息保存到指定的队列中
     *
     * @param rabbitTemplate 消息队列模板
     * @return 消息恢复器
     */
    @Bean
    public MessageRecoverer messageRecoverer(RabbitTemplate rabbitTemplate) {
        return new RepublishMessageRecoverer(rabbitTemplate, "direct.error.exchange", "error");
    }
}
