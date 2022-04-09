package com.design.pattern.singleton;

import lombok.Data;

/**
 * 懒汉式单例模式
 * 多线程情况下会有线程安全问题,
 * 会违反单列模式的设计原则,在内存里会有两个实例
 *
 * @author lfgao
 */
@Data
public class LazySingleton {
    private static LazySingleton lazySingleton;

    private Integer code;

    private Object data;

    /**
     * 单例模式的核心就是将构造函数私有化
     */
    private LazySingleton() {
    }

    /**
     * 给这个方法加上synchronized修饰的化就是线程安全的,否则线程不安全
     *
     * @return LazySingleton
     */
    public static LazySingleton getInstance(Object data) {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
            lazySingleton.setData(data);
        }
        return lazySingleton;
    }
}
