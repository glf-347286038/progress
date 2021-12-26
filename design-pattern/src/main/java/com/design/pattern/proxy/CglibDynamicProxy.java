package com.design.pattern.proxy;

import lombok.extern.log4j.Log4j2;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理拦截器
 *
 * @Author: golf
 * @Date: 2021/12/26 14:29
 */
@Log4j2
public class CglibDynamicProxy implements MethodInterceptor {
    private Object object;

    public Object getInstance(Object object) {
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * @param o           cglib生成的代理对象
     * @param method      被代理对象的方法
     * @param objects     方法入参
     * @param methodProxy 代理方法
     * @return 代理方法的返回值
     * @throws Throwable 异常
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("{}类的{}()方法入参为:{}", object, method.getName(), objects);
        Object response = methodProxy.invokeSuper(o, objects);
        log.info("{}类的{}()方法响应结果为为:{}", object, method.getName(), response);
        return response;
    }
}
