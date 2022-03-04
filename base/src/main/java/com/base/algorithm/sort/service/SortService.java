package com.base.algorithm.sort.service;

import java.util.List;

public interface SortService {
    /**
     * 冒泡排序
     *
     * @return 顺序的集合
     */
    List<Integer> bubbleSort(List<Integer> oldList);
}
