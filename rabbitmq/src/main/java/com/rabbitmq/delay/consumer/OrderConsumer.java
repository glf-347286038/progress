package com.rabbitmq.delay.consumer;

import com.rabbitmq.Common;
import com.rabbitmq.delay.DelayProductController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: golf
 * @Date: 2022/5/6 21:35
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "direct.delay.dead.queue"),
        exchange = @Exchange(value = "direct_delay_dead_exchange")))
public class OrderConsumer {
    private final RabbitTemplate rabbitTemplate;

    public OrderConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitHandler
    public void orderConsumer(DelayProductController.CreateOrderRequest message) {
        // 10后收到延时队列中的下单消息,说明10秒中没有进行订单进行支付(确认)
        log.info("订单10s内未支付,消息内容:{}", message);
        // 取消订单
        log.info("开始取消订单,将单号:{}状态置为已取消", message.getOrderNo());
        // 发送sms短信给用户
        String smsMessage = String.format("%s%s%s", "亲爱的", message.getUserName(), "你有一条超时未支付的订单已被取消");
        rabbitTemplate.convertSendAndReceive(Common.EXCHANGE_NAME, Common.ROUTING_KEY2, smsMessage);
    }
}
