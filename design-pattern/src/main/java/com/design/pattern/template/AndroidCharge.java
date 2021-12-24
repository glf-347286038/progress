package com.design.pattern.template;

import lombok.extern.log4j.Log4j2;

/**
 * 安卓充电
 *
 * @Author: gaolingfeng
 * @Date: 2021/12/23 23:04
 */
@Log4j2
public class AndroidCharge extends AbstractCharge {
    @Override
    String chooseChargingLine() {
        log.info("选择了type-c充电线");
        return "type-c充电线";
    }

    @Override
    String choosePhone() {
        log.info("选择的手机是华为Mate 40");
        return "华为Mate 40";
    }

    @Override
    boolean hookChooseChargingLine() {
        return Boolean.FALSE;
    }
}
