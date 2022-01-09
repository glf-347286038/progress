package com.design.pattern.observer.javase;

/**
 * @Author: golf
 * @Date: 2022/1/9 23:08
 */
public interface Observer {
    /**
     * 关闭处于初始阶段类型订单   第三方观察者
     *
     * @param orderNo 订单号
     */
    void closeInitialStageOrder(String orderNo);

    /**
     * 关闭处于第二阶段的订单
     *
     * @param orderNo 订单号
     */
    void closeSecondStageOrder(String orderNo);
}
