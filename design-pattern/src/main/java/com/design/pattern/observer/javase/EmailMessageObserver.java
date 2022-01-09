package com.design.pattern.observer.javase;

import lombok.extern.slf4j.Slf4j;

/**
 * 邮件消息观察者/订阅者
 *
 * @Author: golf
 * @Date: 2022/1/9 23:59
 */
@Slf4j
public class EmailMessageObserver implements Observer {

    public EmailMessageObserver(Subject subject) {
        // 相当于进行了订阅,其实可以根据配置来进行具体的订阅
        subject.addObserver(this);
    }

    @Override
    public void closeInitialStageOrder(String orderNo) {
        log.info("关闭的初始阶段订单发送邮件给系统超管,订单号:{}", orderNo);
    }

    @Override
    public void closeSecondStageOrder(String orderNo) {
        log.info("关闭的第二阶段订单发送邮件给系统超管和运营人员,订单号:{}", orderNo);
    }
}
