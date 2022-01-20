package com.design.pattern.singleton;

import lombok.Data;

/**
 * @Author: golf
 * @Date: 2022/1/20 20:51
 */
@Data
public class DoubleCheckLockingSingleton {
    private volatile static DoubleCheckLockingSingleton doubleCheckLockingSingleton;
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
