package com.design.pattern.observer.spring.listener;

import com.alibaba.fastjson.JSON;
import com.design.pattern.observer.spring.event.OrderOperationEvent;
import com.design.pattern.observer.spring.model.OrderOperationInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 订单更新监听器
 *
 * @author golf
 * @date 2022/10/21 11:32
 */
@Order(2)
@Slf4j
@Component
public class OrderOperationEventStatusListener {
    @SneakyThrows
    @EventListener(OrderOperationEvent.class)
    public void onApplicationEvent(OrderOperationEvent event) {
        OrderOperationInfo orderOperationInfo = (OrderOperationInfo) event.getSource();
        log.info("订单操作更新监听器监听到事件,{}", JSON.toJSONString(orderOperationInfo));
        Thread.sleep(10000);
        log.info("更新完成");
    }
}
