package com.design.pattern.observer.javase;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者/事件发布者
 *
 * @Author: golf
 * @Date: 2022/1/9 23:05
 */
public class Subject {
    /**
     * 观察者/订阅者集合list
     */
    List<Observer> observerList = new ArrayList<>();


    /**
     * 增加观察者/订阅者
     * 观察者可以根据数据库/配置文件进行具体的事件订阅
     *
     * @param observer 具体观察者
     */
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 关闭初始阶段订单通知所有观察者
     *
     * @param order 订单号
     */
    public void notifyAllObserversWhenCloseInitialStageOrder(String order) {
        for (Observer observer : observerList) {
            observer.closeInitialStageOrder(order);
        }
    }

    /**
     * 关闭第二阶段订单通知所有观察者
     *
     * @param order 订单号
     */
    public void notifyAllObserversWhenCloseSecondStageOrder(String order) {
        for (Observer observer : observerList) {
            observer.closeSecondStageOrder(order);
        }
    }
}
