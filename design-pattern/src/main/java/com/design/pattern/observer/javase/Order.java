package com.design.pattern.observer.javase;

import lombok.Data;

/**
 * 订单
 *
 * @Author: golf
 * @Date: 2022/1/11 21:38
 */
@Data
public class Order {
    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 阶段
     */
    private Integer stage;

    /**
     * 状态
     */
    private Integer status;
}
