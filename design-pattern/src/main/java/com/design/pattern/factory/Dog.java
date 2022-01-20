package com.design.pattern.factory;

import lombok.extern.log4j.Log4j2;

/**
 * @Author: golf
 * @Date: 2022/1/20 22:43
 */
@Log4j2
public class Dog implements Animal {
    @Override
    public void move() {
        log.info("史卢比走路");
    }
}
