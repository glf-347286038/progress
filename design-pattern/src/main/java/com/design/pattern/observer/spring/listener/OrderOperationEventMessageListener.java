package com.design.pattern.observer.spring.listener;

import com.alibaba.fastjson.JSON;
import com.design.pattern.observer.spring.event.OrderOperationEvent;
import com.design.pattern.observer.spring.model.OrderOperationEnum;
import com.design.pattern.observer.spring.model.OrderOperationInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 订单操作消息监听器
 *
 * @author golf
 * @date 2022/10/21 9:06
 */
@Async
@Slf4j
@Component
public class OrderOperationEventMessageListener implements ApplicationListener<OrderOperationEvent> {
    @Override
    public void onApplicationEvent(OrderOperationEvent event) {
        OrderOperationInfo orderOperationInfo = (OrderOperationInfo) event.getSource();
        log.info("订单操作消息监听器监听到事件,{}", JSON.toJSONString(orderOperationInfo));
        OrderOperationEnum orderOperationEnum = OrderOperationEnum.getInstance(orderOperationInfo.getOperation());
        if (orderOperationEnum == null) {
            log.error("错误的订单操作:{}", JSON.toJSONString(orderOperationInfo));
            return;
        }
        switch (orderOperationEnum) {
            case PLACE_AN_ORDER:
                log.info("发送消息给卖家,买家已下单，订单号为：{}", orderOperationInfo.getOrderNo());
                break;
            case PAYMENT:
                log.info("发送消息给卖家,买家已付款，订单号为：{}", orderOperationInfo.getOrderNo());
                break;
            case BUYER_CANCEL:
                log.info("发送消息卖家,买家已取消订单，订单号为：{}", orderOperationInfo.getOrderNo());
                break;
            case SELLER_CANCEL:
                log.info("发送消息买家，卖家已取消订单，订单号为：{}", orderOperationInfo.getOrderNo());
                break;
            default:
                log.info("订单操作:{},无需发送消息", orderOperationEnum.getOperation());
        }
    }
}
