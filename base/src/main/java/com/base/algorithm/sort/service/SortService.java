package com.base.algorithm.sort.service;

import java.util.List;

/**
 * @author golf
 */
public interface SortService {
    /**
     * 冒泡排序
     *
     * @param oldList 旧列表
     * @return 顺序的集合
     */
    List<Integer> bubbleSort(List<Integer> oldList);

    /**
     * 快速排序
     *
     * @param originalArray 原始数组
     * @param left          左指针
     * @param right         右指针
     */
    void quickSort(Integer[] originalArray, Integer left, Integer right);
}
