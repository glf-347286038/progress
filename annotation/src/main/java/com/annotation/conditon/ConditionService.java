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
     * @return {@link Os}
     */
    Os getOs();

    /**
     * 获得ConditionalOnBeanTest
     *
     * @return {@link ConditionalOnBeanTest}
     */
    ConditionalOnBeanTest getConditionalOnBeanTest();

    /**
     * 获得ConditionalOnMissingBeanTest对象
     *
     * @return {@link ConditionalOnMissingBeanTest}
     */
    ConditionalOnMissingBeanTest getConditionalOnMissingBeanTest();
}
