package com.base.concurrent.thread.impl;

import com.base.concurrent.thread.ThreadService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Author: golf
 * @Date: 2022/3/7 20:58
 */
@Log4j2
@Service
@SuppressWarnings("all")
public class ThreadServiceImpl implements ThreadService {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    @Override
    public void createByExtend() {
        Thread thread = new Thread(() -> log.info("createByExtend() lambda匿名内部类中调用"));
        thread.setName("createByExtend() Thread");
        thread.start();
    }

    @Override
    public void runnableType() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("runnableType()调用");
            }
        };
        Thread thread = new Thread(runnable);
        thread.setName("runnableType() Thread");
        thread.start();
    }

    @Override
    public Integer callableType() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            log.info("callableType() 方法调用");
            return 100;
        });
        new Thread(futureTask, "callableType() Thread").start();
        return futureTask.get();
    }

    @Override
    public void threadPoolType() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            Runnable runnable = () -> log.info("当前线程名称:{}", Thread.currentThread().getName());
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }

    @SneakyThrows
    @Override
    public Map<Integer, String> multitaskingConcurrent(List<List<Integer>> paramList) {
        Map<Integer, String> result = new HashMap<>();
        List<FutureTask<Map<Integer, String>>> futureTaskList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (List<Integer> param : paramList) {
            // 传入Callable对象创建FutureTask对象
            FutureTask<Map<Integer, String>> futureTask = new FutureTask<>(new MyCallable(param));
            futureTaskList.add(futureTask);
            // 提交给线程池执行任务
            executorService.submit(futureTask);
        }
        for (FutureTask<Map<Integer, String>> futureTask : futureTaskList) {
            // get方法会自动阻塞,直到获取到结果为止
            result.putAll(futureTask.get());
        }
        return result;
    }

    @Override
    public String getValueFromThreadLocal() {
        log.info("getValueFromThreadLocal:THREAD_LOCAL{}", THREAD_LOCAL);
        String threadValue = THREAD_LOCAL.get();
        THREAD_LOCAL.remove();
        return threadValue;
    }

    @Override
    public void putValueToThreadLocal(String value) {
        THREAD_LOCAL.set(value);
        log.info("putValueToThreadLocal:THREAD_LOCAL{}", THREAD_LOCAL);
    }

    //    @SneakyThrows
    @SneakyThrows
    @Override
    public Map<String, Integer> countDownLatchService(List<Integer> param) {
        Map<String, Integer> response = new LinkedHashMap<>(4);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Runnable runnable1 = () -> {
            // 线程一做加法运算
            Integer addResult = 0;
            for (Integer object : param) {
                addResult += object;
            }
            response.put(Thread.currentThread().getName() + countDownLatch.getCount(), addResult);
            countDownLatch.countDown();
        };
        Thread thread1 = new Thread(runnable1);
        thread1.setName("线程一");
        thread1.start();

        Runnable runnable2 = () -> {
            // 线程2做乘法
            Integer multiplyResult = 1;
            for (Integer object : param) {
                multiplyResult *= object;
            }
            response.put(Thread.currentThread().getName() + countDownLatch.getCount(), multiplyResult);
            countDownLatch.countDown();
        };
        Thread thread2 = new Thread(runnable2);
        thread2.setName("线程二");
        thread2.start();
        // 主线程等待子线程执行完才可以开始执行一些操作
        countDownLatch.await();
        response.put(Thread.currentThread().getName() + countDownLatch, 0);
        return response;
    }

    private static class MyCallable implements Callable<Map<Integer, String>> {
        /**
         * 入参
         */
        private final List<Integer> paramList;

        public MyCallable(List<Integer> paramList) {
            this.paramList = paramList;
        }

        @Override
        public Map<Integer, String> call() {
            Map<Integer, String> result = new HashMap<>(4);
            for (Integer param : paramList) {
                // 根据key做处理
                String description;
                if (param < 100) {
                    description = "不足一百";
                } else if (param < 200) {
                    description = "大于等于100但小于200";
                } else if (param < 300) {
                    description = "大于等于200但小于300";
                } else {
                    description = "大于等于300";
                }
                result.put(param, param + description);
            }
            return result;
        }
    }
}
