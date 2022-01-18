package com.annotation.import01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class GeneralClassATest {
    @Autowired
    private GeneralClassA generalClassA;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void printName() {
        boolean result = generalClassA.check();
        String[] names = applicationContext.getBeanDefinitionNames();
        Object object = applicationContext.getBean("com.annotation.import01.GeneralClassA");
        assert result;
    }

}