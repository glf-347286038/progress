package com.design.pattern.observer.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Golf  操作  operation
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    /**
     * 订单状态枚举信息   已发货
     */
    TO_BE_PAID(1, "买家待付款:刚拍下宝贝,尚未付款"),
    PAID(2, "买家已付款,等待卖家发货:已经付款到支付宝,但是淘宝卖家还未发货"),
    SHIPPED(3, "卖家已发货,等待买家确认:卖家已经发货了,等待用户进行确认收货操作,当确认收货后,货款才会真正打给卖家"),
    SUCCESSFUL_TRADE(4,"交易成功:交易已经成功，货款已经打给卖家"),
    CLOSED(5, "交易关闭:拍下宝贝但一直没有付款,7天后交易将会自动关闭");

    private final Integer status;

    private final String desc;

}
