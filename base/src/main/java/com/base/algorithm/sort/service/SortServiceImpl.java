package com.base.algorithm.sort.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 排序实现类
 */
@Service
public class SortServiceImpl implements SortService {
    @Override
    public List<Integer> bubbleSort(List<Integer> oldList) {
        if (CollectionUtils.isEmpty(oldList)) {
            return oldList;
        }
        for (int i = 0; i < oldList.size() - 1; i++) {
            // 外层遍历一遍之后,最后一个数为最大的,
            for (int j = 0; j < oldList.size() - 1 - i; j++) {
                if (oldList.get(j) > oldList.get(j + 1)) {
                    int temp = oldList.get(j);
                    oldList.set(j, oldList.get(j + 1));
                    oldList.set(j + 1, temp);
                }
            }
        }
        return oldList;
    }

    @Override
    public void quickSort(Integer[] originalArray, Integer left, Integer right) {
        // 终止递归的条件
        if (left >= right) {
            return;
        }
        // 1.基准数
        Integer base = originalArray[left];
        int i = left;
        int j = right;
        // 此遍历的目的是将数组分为两个数组，一部分数组中的数比base小,另一部分数组比base大
        while (i < j) {
            // 2.从右往左直到找到一个比基准数小的数
            while (originalArray[j] >= base && i < j) {
                j--;
            }
            // 3.从左往右直到找到一个比基准数大的数
            while (originalArray[i] <= base && i < j) {
                i++;
            }
            // 交换i,j下标处的数据
            if (i <= j) {
                Integer temp = originalArray[i];
                originalArray[i] = originalArray[j];
                originalArray[j] = temp;
            }
        }
        // 跳出while表示,i和j相遇了,此时i下标的左边的数<=基准数 右边的数>=基准数

        originalArray[left] = originalArray[i];
        // 5.将i,j相遇的地方设置为新的基准数
        originalArray[i] = base;
        // 5对小于基准数的数组进行递归排序 对大于基准数的数组进行递归排序
        quickSort(originalArray, left, i - 1);
        quickSort(originalArray, i + 1, right);
    }
}
