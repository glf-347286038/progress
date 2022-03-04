package com.base.algorithm.sort.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

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
}