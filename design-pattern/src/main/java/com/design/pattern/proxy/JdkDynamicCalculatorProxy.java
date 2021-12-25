package com.design.pattern.proxy;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理Calculator接口
 *
 * @Author: golf
 * @Date: 2021/12/25 23:46
 */
@Log4j2
public class JdkDynamicCalculatorProxy implements InvocationHandler {

    private final Object object;

    public JdkDynamicCalculatorProxy(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("{}类的{}()参数为:{}", object.toString(), method.getName(), args);
        Object response = method.invoke(object, args);
        log.info("{}类的{}()响应结果为:{}", object.toString(), method.getName(), response);
        return response;
    }
}
