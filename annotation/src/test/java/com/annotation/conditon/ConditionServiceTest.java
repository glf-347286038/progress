package com.annotation.conditon;

import com.annotation.conditon.pojo.ConditionalOnBeanTest;
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

    @Test
    void getConditionalOnBeanTest() {
        ConditionalOnBeanTest conditionalOnBeanTest = conditionService.getConditionalOnBeanTest();
        assert conditionalOnBeanTest.getName().equals("测试@ConditionalOnBean");
    }
}
