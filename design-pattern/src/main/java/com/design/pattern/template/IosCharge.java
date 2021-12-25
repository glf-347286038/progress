package com.design.pattern.template;

import lombok.extern.log4j.Log4j2;

/**
 * ios充电
 *
 * @Author: golf
 * @Date: 2021/12/23 23:04
 */
@Log4j2
public class IosCharge extends AbstractCharge {
    @Override
    String chooseChargingLine() {
        log.info("选择了lightning充电线");
        return "lightning";
    }

    @Override
    String choosePhone() {
        log.info("选择了iphone 13");
        return "iphone 13";
    }

    @Override
    boolean hookChooseChargingLine() {
        return Boolean.TRUE;
    }
}
