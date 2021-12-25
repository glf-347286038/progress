package com.design.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: golf
 * @Date: 2021/12/26 0:33
 */
public class JdkDynamicProxyTest {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        // ClassLoader loader,用哪个类加载器去加载代理对象
        // Class<?>[] interfaces,动态代理对象需要实现的接口
        // InvocationHandler h 动态代理方法在执行时，会调用h方法里面的invoke方法去执行
        Calculator jdkDynamicCalculatorProxy = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), new Class[]{Calculator.class},
                new JdkDynamicCalculatorProxy(calculator));
        jdkDynamicCalculatorProxy.sum(2, 3);
        jdkDynamicCalculatorProxy.multiply(2, 3);

    }
}
