package com.annotation.conditon.impl;

import com.annotation.conditon.ConditionService;
import com.annotation.conditon.Os;
import com.annotation.conditon.pojo.ConditionalOnBeanTest;
import org.springframework.stereotype.Service;

/**
 * 实现类
 *
 * @author lfgao
 */
@Service
public class ConditionServiceImpl implements ConditionService {

    private final Os os;

    private final ConditionalOnBeanTest conditionalOnBeanTest;

    public ConditionServiceImpl(Os os, ConditionalOnBeanTest conditionalOnBeanTest) {
        this.os = os;
        this.conditionalOnBeanTest = conditionalOnBeanTest;
    }

    @Override
    public Os getOs() {
        return os;
    }

    @Override
    public ConditionalOnBeanTest getConditionalOnBeanTest() {
        return conditionalOnBeanTest;
    }
}
