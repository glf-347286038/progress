package com.base.se.finalService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: golf
 * @Date: 2022/5/9 21:14
 */
@Slf4j
public class Demo {

    final String CODE;

    public Demo(String code) {
        CODE = code;
    }

    public static void main(String[] args) {
        final int i = 10;
        // i = 9;    修改不了
        log.info("i:{}", i);
        final int[] arr = {1, 2, 3};
        arr[2] = 11;
        for (int ele : arr) {
            log.info("ele:{}", ele);
        }

        String str = "golf";
        log.info("str:{}", str);
        str = "test";
        log.info("str:{}", str);

    }
}
