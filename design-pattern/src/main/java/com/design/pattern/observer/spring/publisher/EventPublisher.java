package com.design.pattern.observer.spring.publisher;

import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 通用事件发布器
 *
 * @author golf
 * @date 2022/10/21 9:48
 */
@Component
public class EventPublisher implements ApplicationContextAware {
    private ApplicationEventPublisher applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public void publish(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }
}
