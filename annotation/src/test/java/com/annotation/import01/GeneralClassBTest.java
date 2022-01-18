package com.annotation.import01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneralClassBTest {
    @Autowired
    private GeneralClassB generalClassB;

    @Test
    void check() {
        assert generalClassB.check();
    }
}