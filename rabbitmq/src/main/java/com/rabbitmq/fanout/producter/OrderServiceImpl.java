package com.rabbitmq.fanout.producter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: golf
 * @Date: 2022/5/3 0:23
 */
@Slf4j
@Component
public class OrderServiceImpl implements OrderService {

    private static final String EXCHANGE_NAME = "fanout_test_exchange";
    private static final String ROUTING_KEY = "";
    private final RabbitTemplate rabbitTemplate;
    private final AtomicInteger numStore = new AtomicInteger(20);

    public OrderServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void saveOrder(Long userId, Integer num) {
        String orderNumber = UUID.randomUUID().toString();
        if (num > numStore.get()) {
            log.error("库存不足");
            return;
        }
        // 扣减库存
        numStore.getAndAdd(-num);
        log.info("用户:{},订单编号:{},剩余库存:{}", userId, orderNumber, numStore);
        // 发送订单信息给rabbitMq fanout
        //不指定routeKey,则三个队列都会收到消息
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, orderNumber);
    }
}
