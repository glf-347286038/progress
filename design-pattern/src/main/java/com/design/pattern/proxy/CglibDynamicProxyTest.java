package com.design.pattern.proxy;

/**
 * @Author: golf
 * @Date: 2021/12/26 16:19
 */
public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        CalculatorImpl calculatorCglibProxy = (CalculatorImpl) cglibDynamicProxy.getInstance(calculator);
        calculatorCglibProxy.sum(2, 3);
        calculatorCglibProxy.multiply(2, 3);
    }
}
