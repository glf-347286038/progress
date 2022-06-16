package com.base.test.delay.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
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
    private static final DelayQueue<Message> DELAY_QUEUE = new DelayQueue<>();

    public static void main(String[] args) {
        Message message = new Message();
        message.setBody("sss");
        message.setExecuteTime(10L);

    }

    /**
     * 接收消息
     *
     * @param message 消息内容
     * @return 结果
     */
    @PostMapping("save/message")
    String putMessage(@RequestBody String message) {
        Message message1 = new Message();
        // 设置消息到期时间 30秒后消息到期
        message1.setExecuteTime(Message.getDateByInterval(new Date(), 5, Calendar.SECOND).getTime());
        message1.setBody(message);
        DELAY_QUEUE.put(message1);
        return "消息发送成功";
    }

    @Override
    public void afterPropertiesSet() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Message message = DELAY_QUEUE.take();
                    if (message.getDelay(TimeUnit.SECONDS) <= 0) {
                        consumingMessage(message);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * 消费消息
     */
    private void consumingMessage(Message message) {
        log.info("开始消费消息,消息内容:{},消息过期时间:{},当前时间:{}",
                message.getBody(), Message.formatOne(message.getExecuteTime()), Message.formatOne(System.currentTimeMillis()));
    }
}
