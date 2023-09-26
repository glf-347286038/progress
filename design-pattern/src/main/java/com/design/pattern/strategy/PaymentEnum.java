package com.design.pattern.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author golf
 * @date 2023/9/26 14:35
 */
@Getter
@AllArgsConstructor
public enum PaymentEnum {
    /**
     * 支付宝
     */
    ALIPAY("zfb"),
    /**
     * 微信
     */
    WECHAT("wx"),
    XX("xx")
    ;


    private final String type;

}
