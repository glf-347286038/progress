package com.base.concurrent.thread;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: golf
 * @Date: 2022/3/7 22:11
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
class ThreadServiceTest {
    @Autowired
    private ThreadService threadService;

    @Test
    void createByExtend() {
        log.info("主方法首次打印日志");
        threadService.createByExtend();
        log.info("主方法再次打印日志");
        Assert.assertTrue(Boolean.TRUE);
    }

    @Test
    void runnableType() {
        log.info("主方法首次打印日志");
        threadService.runnableType();
        log.info("主方法再次打印日志");
        Assert.assertTrue(Boolean.TRUE);
    }

    @SneakyThrows
    @Test
    void callableType() {
        log.info("主方法首次打印日志");
        Integer value = threadService.callableType();
        log.info("主方法再次打印日志,callable返回值:{}", value);
        Assert.assertTrue(Boolean.TRUE);
    }

    @Test
    void multitaskingConcurrent() {
        List<List<Integer>> paramList = new ArrayList<>();
        List<Integer> param1 = new ArrayList<>();
        List<Integer> param2 = new ArrayList<>();
        List<Integer> param3 = new ArrayList<>();
        List<Integer> param4 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            param1.add(i);
            param2.add(i * 100);
            param3.add(i * 200);
            param4.add(i * 300);
        }
        paramList.add(param1);
        paramList.add(param2);
        paramList.add(param3);
        paramList.add(param4);
        Map<Integer, String> result = threadService.multitaskingConcurrent(paramList);
        log.info(result);
        Assert.assertNotNull(result);
    }

    @Test
    void getValueFromThreadLocal() {
        String threadLocalValue1 = "线程1";
        Runnable runnable = () -> {
            threadService.putValueToThreadLocal(threadLocalValue1);
            String expected1 = threadService.getValueFromThreadLocal();
            Assert.assertEquals(threadLocalValue1, expected1);
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();


        String threadLocalValue2 = "线程2";
        Runnable runnable2 = () -> {
            threadService.putValueToThreadLocal(threadLocalValue2);
            String expected2 = threadService.getValueFromThreadLocal();
            Assert.assertEquals(threadLocalValue2, expected2);

        };
        Thread thread = new Thread(runnable2);
        thread.start();
    }
}
