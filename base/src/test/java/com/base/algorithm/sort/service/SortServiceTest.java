package com.base.algorithm.sort.service;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
class SortServiceTest {
    @Autowired
    private SortService sortService;

    @Test
    void bubbleSort() {
        List<Integer> newList = sortService.bubbleSort(Arrays.asList(9, 7, 3, 5, 1, 66, 77, 33));
        int minValue = newList.get(0);
        int maxValue = newList.get(newList.size() - 1);
        Assert.assertEquals(1, minValue);
        Assert.assertEquals(77, maxValue);
    }

    @Test
    void quickSort() {
        Integer[] originalArray = {10, 9, 8, 1, 2, 3, 2};
        sortService.quickSort(originalArray, 0, originalArray.length - 1);
        log.info("快速排序之后的数组:{}", Arrays.asList(originalArray));
        Integer minValue = originalArray[0];
        Assert.assertEquals(Integer.valueOf(1), minValue);
    }
}