package com.design.pattern.observer.javase;


/**
 * @Author: golf
 * @Date: 2022/1/10 0:30
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new AppMessageObserver(subject);
        new EmailMessageObserver(subject);
        new ThirdPartyObserver(subject);

        subject.notifyAllObserversWhenCloseInitialStageOrder("DD111");
        subject.notifyAllObserversWhenCloseSecondStageOrder("DD222");

    }
}
