package com.base.concurrent.lock;

/**
 * @author golf
 */
public interface LockService {
    /**
     * 测试ReentrantLock
     *
     * @return 抢票成功
     */
    Boolean testReentrantLock();

    /**
     * 手写一个必然死锁的例子
     * 死锁并不会导致系统崩溃等问题,但是造成业务逻辑错误问题
     */
    void deadLock();
}
