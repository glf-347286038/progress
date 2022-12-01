package com.base.concurrent.lock.impl;

import com.base.concurrent.lock.LockService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁实现类
 *
 * @author golf
 */
@Log4j2
@Service
public class LockServiceImpl implements LockService {
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;
    ReentrantLock reentrantLock = new ReentrantLock();
    /**
     * 票的数量
     */
    private int ticketCount = 3;

    private final Object lockOne = new Object();
    private final Object lockTwo = new Object();

    public LockServiceImpl(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    @Override
    public Boolean testReentrantLock() {
        // 加锁
        reentrantLock.lock();
        try {
            if (ticketCount <= 0) {
                log.info("无余票");
                return Boolean.FALSE;
            }
            ticketCount--;
            String currentThreadName = Thread.currentThread().getName();
            log.info("线程{}抢票成功,当前剩余票数:{}", currentThreadName, ticketCount);
        } catch (Exception e) {
            log.error("LockServiceImpl.testReentrantLock()出错", e);
        } finally {
            reentrantLock.unlock();
        }
        return Boolean.TRUE;
    }

    @Override
    public void deadLock() {
        threadPoolTaskExecutor.submit(this::getLockOne);
        threadPoolTaskExecutor.submit(this::getLockTwo);
    }

    @SneakyThrows
    private void getLockOne() {
        log.info("：{}", Thread.currentThread().getName());
        synchronized (lockOne) {

            Thread.sleep(1000);
            log.info("{}获得锁1", Thread.currentThread().getName());
            synchronized (lockTwo) {
                log.info("{}获得锁2", Thread.currentThread().getName());
            }
        }

    }

    @SneakyThrows
    private void getLockTwo() {
        log.info("：{}", Thread.currentThread().getName());
        synchronized (lockTwo) {
            Thread.sleep(1000);
            log.info("{}获得锁2", Thread.currentThread().getName());
            synchronized (lockOne) {
                log.info("{}获得锁1", Thread.currentThread().getName());
            }
        }

    }
}
