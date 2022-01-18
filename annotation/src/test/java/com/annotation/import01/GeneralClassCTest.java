package com.annotation.import01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneralClassCTest {
    @Autowired
    private GeneralClassC generalClassC;

    @Test
    void check() {
        assert generalClassC.check();
    }
}