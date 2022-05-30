package com.base.test.delay.queue;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.DelayQueue;

/**
 * @author lfgao
 */
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
    String putMessage(@RequestBody Message message) {
        DELAY_QUEUE.put(message);
        return "消息发送成功";
    }

    @Override
    public void afterPropertiesSet() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Message message = DELAY_QUEUE.take();
//                    if(){
//
//                    }
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
