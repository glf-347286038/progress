package com.annotation.conditon;

import com.annotation.conditon.pojo.ConditionalOnBeanTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ConditionServiceTest {
    @Autowired
    private ConditionService conditionService;


    @Test
    void getOs() {
        Os os = conditionService.getOs();
        Assert.assertEquals("Windows", os.getName());
    }

    @Test
    void getConditionalOnBeanTest() {
        ConditionalOnBeanTest conditionalOnBeanTest = conditionService.getConditionalOnBeanTest();
        assert conditionalOnBeanTest.getName().equals("测试@ConditionalOnBean");
    }

    @Test
    void getConditionalOnMissingBeanTest() {
        Assert.assertNotNull(conditionService.getConditionalOnMissingBeanTest());
    }
}
