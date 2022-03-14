package com.base.concurrent.thread;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Author: golf
 * @Date: 2022/3/7 20:57
 */
public interface ThreadService {
    void createByExtend();

    void runnableType();

    Integer callableType() throws ExecutionException, InterruptedException;

    Map<Integer, String> multitaskingConcurrent(List<List<Integer>> paramList);

    String getValueFromThreadLocal();

    void putValueToThreadLocal(String value);
}
