package com.design.pattern.factory;

import lombok.extern.log4j.Log4j2;

/**
 * @Author: golf
 * @Date: 2022/1/20 22:44
 */
@Log4j2
public class Cat implements Animal {
    @Override
    public void move() {
        log.info("汤姆猫走路");
    }
}
