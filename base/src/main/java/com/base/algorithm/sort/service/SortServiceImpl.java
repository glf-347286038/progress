package com.base.algorithm.sort.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 排序实现类
 *
 * @author golf
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
        int l = left;
        int r = right;
        // 基准数
        int base = originalArray[l];
        // 此遍历的目的是将数组分为两个数组，一部分数组中的数比base小
        while (l < r) {
            // 从右往左找到比base小的数
            while (l < r && originalArray[r] >= base) {
                r--;
            }
            // 从左往右找到比base大的数
            while (l < r && originalArray[l] <= base) {
                l++;
            }
            // 将比base大的数和比base小的数进行交换
            if (l < r) {
                int temp = originalArray[l];
                originalArray[l] = originalArray[r];
                originalArray[r] = temp;
            }
        }
        // 将基准数与l下标处进行交换,这样第一遍排序过后左边的数<=基准数 右边的数>=基准数
        originalArray[left] = originalArray[l];
        originalArray[l] = base;

        // 将基准数左右两边的数组进行递归
        quickSort(originalArray, left, l - 1);
        quickSort(originalArray, l + 1, right);
    }
}
