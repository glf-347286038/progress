package com.design.pattern.singleton;

import lombok.Data;

/**
 * @Author: golf
 * @Date: 2022/1/20 20:51
 */
@Data
public class DoubleCheckLockingSingleton {
    /**
     * volatile关键词有两个作用，一个是可见性一个是禁止指令重排序
     * volatile可见性只对基本类型生效,这里只是用了volatile禁止指令重排序的功能
     * 而sonar只认第一种功能,所以提示错误,这种sonar问题可以忽略,对象不是final的,
     * 对象的引用可以变化,如果引用发生了仍然解决不了不可见的问题
     */
    private static volatile DoubleCheckLockingSingleton doubleCheckLockingSingleton;
    private String code;

    private DoubleCheckLockingSingleton() {
    }

    public static DoubleCheckLockingSingleton getInstance() {
        if (doubleCheckLockingSingleton == null) {
            synchronized (DoubleCheckLockingSingleton.class) {
                if (doubleCheckLockingSingleton == null) {
                    doubleCheckLockingSingleton = new DoubleCheckLockingSingleton();
                }
            }
        }
        return doubleCheckLockingSingleton;
    }
}
