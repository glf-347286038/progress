package com.design.pattern.strategy.controller;

import com.design.pattern.strategy.PaymentEnum;
import com.design.pattern.strategy.PaymentStrategyContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author golf
 * @date 2022/10/21 9:53
 */
@RequiredArgsConstructor
@RequestMapping("strategy")
@RestController
public class StrategyController {
    private final PaymentStrategyContext paymentStrategyContext;

    @GetMapping("/pay/{paymentEnum}")
    public String pay(@PathVariable PaymentEnum paymentEnum) {
        paymentStrategyContext.getPaymentStrategy(paymentEnum).pay(100);
        return "operate success!";
    }


    @GetMapping("/dealPay/{paymentEnum}")
    public String dealPay(@PathVariable PaymentEnum paymentEnum) {
        paymentStrategyContext.getPaymentStrategy(paymentEnum).dealPay();
        return "operate success!";
    }
}
