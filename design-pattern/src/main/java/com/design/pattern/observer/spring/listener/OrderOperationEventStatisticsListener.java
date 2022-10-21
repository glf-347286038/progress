package com.design.pattern.observer.spring.listener;

import com.alibaba.fastjson.JSON;
import com.design.pattern.observer.spring.event.OrderOperationEvent;
import com.design.pattern.observer.spring.model.OrderOperationEnum;
import com.design.pattern.observer.spring.model.OrderOperationInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 订单事件统计监听器
 *
 * @author golf
 * @date 2022/10/21 11:04
 */
@Async
@Order(1)
@Slf4j
@Component
public class OrderOperationEventStatisticsListener implements ApplicationListener<OrderOperationEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderOperationEvent event) {
        OrderOperationInfo orderOperationInfo = (OrderOperationInfo) event.getSource();
        log.info("订单操作统计监听器监听到事件,{}", JSON.toJSONString(orderOperationInfo));
        OrderOperationEnum orderOperationEnum = OrderOperationEnum.getInstance(orderOperationInfo.getOperation());
        if (orderOperationEnum == null) {
            log.error("错误的订单操作:{}", JSON.toJSONString(orderOperationInfo));
            return;
        }
        if(true){
            throw new Exception("ssss");
        }
        switch (orderOperationEnum) {
            case PLACE_AN_ORDER:
                log.info("买家已下单,订单号为：{},下单数量+1", orderOperationInfo.getOrderNo());
                break;
            case PAYMENT:
                log.info("买家已付款,订单号为：{},付款数量+1", orderOperationInfo.getOrderNo());
                break;
            case BUYER_CANCEL:
                log.info("买家已取消订单,订单号为:{},买家取消订单数量-1", orderOperationInfo.getOrderNo());
                break;
            case SELLER_CANCEL:
                log.info("卖家已取消订单,订单号为:{},卖家取消订单数量-1", orderOperationInfo.getOrderNo());
                break;
            default:
                log.info("订单操作:{},无需统计", orderOperationEnum.getOperation());
        }
    }
}
