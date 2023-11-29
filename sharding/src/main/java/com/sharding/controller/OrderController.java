package com.sharding.controller;

import com.sharding.entity.Order;
import com.sharding.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author golf
 * @date 2023/11/29 11:01
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") Long id) {
        return orderService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Order order) {
        orderService.save(order);
    }
}
