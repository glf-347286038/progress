package com.rabbitmq.delay;

import com.rabbitmq.Common;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

/**
 * @Author: golf
 * @Date: 2022/5/6 20:32
 */
@Slf4j
@RequestMapping("/delay")
@RestController
public class DelayProductController {
    private final RabbitTemplate rabbitTemplate;

    public DelayProductController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 创建订单
     *
     * @param request 创建订单参数
     * @return 消息
     */
    @PostMapping("/createOrder")
    public String createOrder(@Validated @RequestBody CreateOrderRequest request) {
//        String date = SimpleDateFormat.
        String orderNo = UUID.randomUUID().toString();
        String message = String.format("%s%s%s", request.getUserName(), "下单成功,单号为", orderNo);
        request.setOrderNo(orderNo);
        // 1.模拟下单成功
        log.info("下单成功,订单号:{}", orderNo);
        // 2.使用消息队列发送sms即时消息
        rabbitTemplate.convertAndSend(Common.EXCHANGE_NAME, Common.ROUTING_KEY2, message);
        // 3.往延时队列中发送订单信息
        rabbitTemplate.convertAndSend(Common.DIRECT_DELAY_EXCHANGE_NAME, Common.DIRECT_DELAY_QUEUE_ROUTING_KEY, request);
        return message;
    }


    @Data
    public static class CreateOrderRequest implements Serializable {
        @NotBlank(message = "用户名不得为空")
        private String userName;
        @NotBlank(message = "商品名称不得为空")
        private String productName;
        /**
         * 商品订单号
         */
        private String orderNo;
    }
}
