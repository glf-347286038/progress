package com.design.pattern.strategy;

/**
 * 策略接口(对拓展开放)
 *
 * @author golf
 * @date 2023/9/26 14:33
 */
public interface PaymentStrategy {

    /**
     * 支付
     *
     * @param money 金额
     */
    void pay(double money);

    /**
     * 处理
     */
    default void dealPay() {
    }
}
