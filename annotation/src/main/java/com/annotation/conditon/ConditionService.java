package com.annotation.conditon;

import com.annotation.conditon.pojo.ConditionalOnBeanTest;
import com.annotation.conditon.pojo.ConditionalOnMissingBeanTest;

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

    /**
     * 获得ConditionalOnMissingBeanTest对象
     *
     * @return ConditionalOnMissingBeanTest
     */
    ConditionalOnMissingBeanTest getConditionalOnMissingBeanTest();
}
