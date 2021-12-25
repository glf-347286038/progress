package com.design.pattern.proxy;

/**
 * 计算器接口
 *
 * @Author: golf
 * @Date: 2021/12/25 20:19
 */
public interface Calculator {
    /**
     * 两个数求和   乘
     *
     * @param i 参数i
     * @param j 参数j
     * @return 求和的结果
     */
    int sum(int i, int j);

    /**
     * 求两数相乘的结果
     *
     * @param i 参数i
     * @param j 参数j
     * @return 乘积结果
     */
    int multiply(int i, int j);
}
