package com.annotation.conditon;

import com.annotation.conditon.impl.ConditionServiceImpl;
import com.annotation.conditon.pojo.ConditionalOnBeanTest;
import com.annotation.conditon.pojo.ConditionalOnMissingBeanTest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author lfgao
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public Os windows() {
        Os windows = new Os();
        windows.setName("Windows");
        return windows;
    }

    @Bean
    @Conditional({LinuxCondition.class})
    public Os linux() {
        Os linux = new Os();
        linux.setName("Linux");
        return linux;
    }

    @ConditionalOnBean(ConditionServiceImpl.class)
    @Bean
    public ConditionalOnBeanTest conditionalOnBeanTest() {
        ConditionalOnBeanTest conditionalOnBeanTest = new ConditionalOnBeanTest();
        conditionalOnBeanTest.setName("测试@ConditionalOnBean");
        return conditionalOnBeanTest;
    }

    @Bean
    @ConditionalOnMissingBean(name = "conditionalOnMissingBeanTest")
    public ConditionalOnMissingBeanTest conditionalOnMissingBeanTest() {
        ConditionalOnMissingBeanTest conditionalOnMissingBeanTest = new ConditionalOnMissingBeanTest();
        conditionalOnMissingBeanTest.setName("测试@ConditionalOnMissingBean");
        return conditionalOnMissingBeanTest;
    }
}
