package com.design.pattern.singleton;

import lombok.extern.log4j.Log4j2;

/**
 * @Author: golf
 * @Date: 2022/1/20 21:49
 */
@Log4j2
public class SingletonTest {
    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance("");
        HungrySingleton hungrySingleton = HungrySingleton.getInstance("");
        DoubleCheckLockingSingleton doubleCheckLockingSingleton = DoubleCheckLockingSingleton.getInstance();
        log.info(lazySingleton);
        log.info(hungrySingleton);
        log.info(doubleCheckLockingSingleton);
    }
}
