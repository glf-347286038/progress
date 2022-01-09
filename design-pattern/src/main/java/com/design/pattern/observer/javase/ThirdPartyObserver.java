package com.design.pattern.observer.javase;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 三方观察者/订阅者/监听者
 *
 * @Author: golf
 * @Date: 2022/1/9 23:39
 */
@Slf4j
public class ThirdPartyObserver implements Observer {

    public ThirdPartyObserver(Subject subject) {
        // 相当于进行了订阅,其实可以根据配置来进行具体的订阅
        subject.addObserver(this);
    }

    @Override
    public void closeInitialStageOrder(String orderNo) {
        log.info("三方观察者收到关闭初始阶段的订单:{},当前系统时间:{}", orderNo, new Date());
    }

    @Override
    public void closeSecondStageOrder(String orderNo) {
        log.info("三方观察者收到关闭第二阶段的订单:{},当前系统时间:{}", orderNo, new Date());
    }
}
