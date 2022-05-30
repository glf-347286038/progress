package com.base.test.delay.queue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 消息接收类
 *
 * @author lfgao
 */
@Data
public class Message implements Delayed {
    /**
     * 内容
     */
    private String body;
    /**
     * 延迟时间
     */
    private Long executeTime;


    @Override
    public long getDelay(TimeUnit unit) {
        return executeTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }
}
