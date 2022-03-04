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
}
