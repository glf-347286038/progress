package com.design.pattern.proxy;

/**
 * 静态代理测试类
 *
 * @Author: golf
 * @Date: 2021/12/25 20:36
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        int i = 2;
        int j = 3;
        calculator.sum(i, j);
        calculator.multiply(i, j);
        Calculator calculatorProxy = new CalculatorProxy(calculator);
        calculatorProxy.sum(i, j);
        calculatorProxy.multiply(i, j);
    }
}
