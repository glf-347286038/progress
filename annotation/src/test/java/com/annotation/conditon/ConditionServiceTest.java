package com.annotation.conditon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConditionServiceTest {
    @Autowired
    private ConditionService conditionService;


    @Test
    void getOs() {
        Os os = conditionService.getOs();
        assert os.getName().equals("Windows");
    }
}