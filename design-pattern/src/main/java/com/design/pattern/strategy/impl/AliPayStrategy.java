package com.design.pattern.strategy.impl;

import com.design.pattern.strategy.PaymentEnum;
import com.design.pattern.strategy.PaymentStrategy;
import com.design.pattern.strategy.PaymentStrategyContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author golf
 * @date 2023/9/26 14:40
 */
@Slf4j
@Service
public class AliPayStrategy implements PaymentStrategy, InitializingBean {
    @Override
    public void afterPropertiesSet() {
        PaymentStrategyContext.putStrategy(PaymentEnum.ALIPAY, this);
    }

    @Override
    public void pay(double money) {
        log.info("支付宝支付金额:{}", money);
    }

    @Override
    public void dealPay() {
        log.info("支付宝dealPay");
    }

}
