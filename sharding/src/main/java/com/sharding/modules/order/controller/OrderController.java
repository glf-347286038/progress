package com.sharding.modules.order.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sharding.modules.order.domain.dto.OrderPageDTO;
import com.sharding.modules.order.domain.entity.Order;
import com.sharding.modules.order.domain.vo.OrderPageVO;
import com.sharding.modules.order.domain.vo.OrderVo;
import com.sharding.modules.order.service.OrderService;
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
    public OrderVo detail(@PathVariable("id") Long id) {
        return orderService.detail(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Order order) {
        orderService.save(order);
    }

    @PostMapping("/batchAdd")
    public void batchAdd(@RequestBody Integer num) {
        orderService.batchAdd(num);
    }

    @PostMapping("/batchAddTwo")
    public void batchAddTwo(@RequestBody Integer num) {
        orderService.batchAddTwo(num);
    }

    @GetMapping("/page")
    public IPage<OrderPageVO> page(Page<Order> page, OrderPageDTO pageDTO) {
        return orderService.page(page, pageDTO);
    }
}
