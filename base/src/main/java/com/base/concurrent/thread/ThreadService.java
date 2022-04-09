package com.base.concurrent.thread;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Author: golf
 * @Date: 2022/3/7 20:57
 */
public interface ThreadService {
    /**
     * 通过集成Thread类创建线程
     */
    void createByExtend();

    /**
     * 使用Runnable创建线程
     */
    void runnableType();

    /**
     * 使用callable创建线程
     *
     * @return 线程返回值
     * @throws ExecutionException   线程执行异常
     * @throws InterruptedException 线程中断异常
     */
    Integer callableType() throws ExecutionException, InterruptedException;

    /**
     * 使用FutureTask+线程池批量处理任务
     *
     * @param paramList 参数
     * @return 返回值
     */
    Map<Integer, String> multitaskingConcurrent(List<List<Integer>> paramList);

    /**
     * 从ThreadLocal中获取值
     *
     * @return ThreadLocal中的值
     */
    String getValueFromThreadLocal();

    /**
     * 往ThreadLocal中存入值
     *
     * @param value 值
     */
    void putValueToThreadLocal(String value);

    /**
     * 测试countDownLatch
     *
     * @param param 参数
     * @return 返回值
     */
    Map<String, Integer> countDownLatchService(List<Integer> param);
}
