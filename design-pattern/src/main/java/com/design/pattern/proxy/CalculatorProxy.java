package com.design.pattern.proxy;

import lombok.extern.log4j.Log4j2;

/**
 * 计算器代理类,实现记录入参和结果
 *
 * @Author: golf
 * @Date: 2021/12/25 20:28
 */
@Log4j2
public class CalculatorProxy implements Calculator {
    private final Calculator calculator;

    public CalculatorProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    public int sum(int i, int j) {
        log.info("Calculator类sum()方法入参为i:{},j:{}", i, j);
        int response = calculator.sum(i, j);
        log.info("Calculator类sum()结果为{}", response);
        return response;
    }

    public int multiply(int i, int j) {
        log.info("Calculator类multiply()方法入参为i:{},j:{}", i, j);
        int response = calculator.multiply(i, j);
        log.info("Calculator类multiply()结果为{}", response);
        return response;
    }
}
