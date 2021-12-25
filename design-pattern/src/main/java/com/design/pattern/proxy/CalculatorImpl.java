package com.design.pattern.proxy;

/**
 * 计算器实现类
 *
 * @Author: golf
 * @Date: 2021/12/25 20:26
 */
public class CalculatorImpl implements Calculator {
    public int sum(int i, int j) {
        return i + j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }
}
