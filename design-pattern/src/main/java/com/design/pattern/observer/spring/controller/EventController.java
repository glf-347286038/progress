package com.design.pattern.observer.spring.controller;

import com.design.pattern.observer.spring.event.OrderOperationEvent;
import com.design.pattern.observer.spring.model.OrderOperationInfo;
import com.design.pattern.observer.spring.publisher.EventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author golf
 * @date 2022/10/21 9:53
 */
@RequestMapping("event")
@RestController
public class EventController {

    private final EventPublisher eventPublisher;

    public EventController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("operate")
    public String operate(@RequestBody OrderOperationInfo orderOperationInfo) {
        eventPublisher.publish(new OrderOperationEvent(orderOperationInfo));
        return "operate success!";
    }
}
