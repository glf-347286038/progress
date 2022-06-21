package com.base.test.delay.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lfgao
 */
@Slf4j
@RequestMapping("delay")
@RestController
public class Controller implements InitializingBean {

    /**
     * 延迟队列
     */
    private static final DelayQueue<DelayedMessage> DELAY_QUEUE = new DelayQueue<>();
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public Controller(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }


    /**
     * 接收消息
     *
     * @param message 消息内容
     * @return 结果
     */
    @PostMapping("save/message")
    String putMessage(@RequestBody DelayMessageVO message) {
        DelayedMessage delayedMessage1 = new DelayedMessage();
        // 设置消息到期时间 30秒后消息到期
        delayedMessage1.setExecuteTime(DelayedMessage.getDateByInterval(new Date(), 20, Calendar.SECOND).getTime());
        delayedMessage1.setBody(message.getMessage());
        DELAY_QUEUE.put(delayedMessage1);
        log.info("接收到消息:{}", message.getMessage());
        return "消息发送成功";
    }

    @Override
    public void afterPropertiesSet() {

        Thread thread = threadPoolTaskExecutor.createThread(() -> {
            while (!Thread.interrupted()) {
                try {
                    DelayedMessage delayedMessage = DELAY_QUEUE.take();
                    if (delayedMessage.getDelay(TimeUnit.SECONDS) <= 0) {
                        consumingMessage(delayedMessage);
                    }
                } catch (InterruptedException e) {
                    log.error("消费消息的守护线程出现异常", e);
                    Thread.currentThread().interrupt();
                    threadPoolTaskExecutor.shutdown();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
//        threadPoolTaskExecutor.createThread(() -> {
//
//            while (!Thread.interrupted()) {
//                try {
//                    DelayedMessage delayedMessage = DELAY_QUEUE.take();
//                    if (delayedMessage.getDelay(TimeUnit.SECONDS) <= 0) {
//                        consumingMessage(delayedMessage);
//                    }
//                } catch (InterruptedException e) {
//                    log.error("消费消息的守护线程出现异常", e);
//                    Thread.currentThread().interrupt();
//                    threadPoolTaskExecutor.shutdown();
//                }
//            }
//        });
    }

    /**
     * 消费消息
     */
    private void consumingMessage(DelayedMessage delayedMessage) {
        log.info("开始消费消息,消息内容:{},消息过期时间:{},当前时间:{}",
                delayedMessage.getBody(), DelayedMessage.formatOne(delayedMessage.getExecuteTime()), DelayedMessage.formatOne(System.currentTimeMillis()));
    }
}
