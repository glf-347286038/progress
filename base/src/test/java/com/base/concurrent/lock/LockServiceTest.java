package com.base.concurrent.lock;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
class LockServiceTest {
    @Autowired
    private LockService lockService;

    @Test
    void testReentrantLock() {
        for (int i = 0; i < 7; i++) {
            Runnable runnable = () -> {
                if (lockService.testReentrantLock()) {
                    log.info("抢票成功");
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
