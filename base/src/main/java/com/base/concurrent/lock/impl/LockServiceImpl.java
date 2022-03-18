package com.base.concurrent.lock.impl;

import com.base.concurrent.lock.LockService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁实现类
 */
@Log4j2
@Service
public class LockServiceImpl implements LockService {
    ReentrantLock reentrantLock = new ReentrantLock();
    /**
     * 票的数量
     */
    private int ticketCount = 3;

    @Override
    public boolean testReentrantLock() {
        log.info("当前线程名称：{}", Thread.currentThread()::getName);
        // 加锁
        reentrantLock.lock();
        try {
            if (ticketCount <= 0) {
                log.info("无余票");
                return Boolean.FALSE;
            }
            ticketCount--;
            log.info("抢票成功,当前剩余票数:{}", ticketCount);
        } catch (Exception e) {
            log.error("LockServiceImpl.testReentrantLock()出错", e);
        } finally {
            reentrantLock.unlock();
        }
        return Boolean.TRUE;
    }
}
