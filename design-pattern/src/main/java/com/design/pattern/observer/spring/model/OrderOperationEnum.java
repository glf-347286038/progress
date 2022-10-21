package com.design.pattern.observer.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Golf
 */
@Getter
@AllArgsConstructor
public enum OrderOperationEnum {
    /**
     * 订单操作枚举类
     */
    PLACE_AN_ORDER(1, "下单"),
    PAYMENT(2, "付款"),
    BUYER_CANCEL(3, "买家取消"),
    SELLER_CANCEL(4, "卖家取消"),
    ;

    public static OrderOperationEnum getInstance(Integer operation) {
        for (OrderOperationEnum operationEnum : OrderOperationEnum.values()) {
            if (operationEnum.getOperation().equals(operation)) {
                return operationEnum;
            }
        }
        return null;
    }

    /**
     * 操作
     */
    private final Integer operation;
    private final String desc;
}
