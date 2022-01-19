package com.annotation.conditon;

import com.annotation.conditon.pojo.ConditionalOnBeanTest;

/**
 * @author golf
 */
public interface ConditionService {
    /**
     * 获得操作系统信息
     *
     * @return 操作系统
     */
    Os getOs();

    /**
     * 获得ConditionalOnBeanTest
     *
     * @return ConditionalOnBeanTest
     */
    ConditionalOnBeanTest getConditionalOnBeanTest();
}
