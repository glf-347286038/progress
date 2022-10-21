package com.design.pattern.observer.spring.model;

import lombok.Data;

/**
 * 订单事件信息类
 *
 * @author golf
 * @date 2022/10/20 16:38
 */
@Data
public class OrderOperationInfo {
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 订单状态{@link OrderOperationEnum}
     */
    private Integer operation;
}

