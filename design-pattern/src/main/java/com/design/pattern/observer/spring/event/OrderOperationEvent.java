package com.design.pattern.observer.spring.event;

import com.design.pattern.observer.spring.model.OrderOperationInfo;
import org.springframework.context.ApplicationEvent;

/**
 * 事件类
 *
 * @author golf
 * @date 2022/10/20 16:39
 */
public class OrderOperationEvent extends ApplicationEvent {
    public OrderOperationEvent(OrderOperationInfo source) {
        super(source);
    }
}
