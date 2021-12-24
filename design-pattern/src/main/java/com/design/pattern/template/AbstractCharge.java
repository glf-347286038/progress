package com.design.pattern.template;

import lombok.extern.log4j.Log4j2;

/**
 * 充电抽象类
 *
 * @Author: gaolingfeng
 * @Date: 2021/12/23 0:15
 */
@Log4j2
public abstract class AbstractCharge {
    // 选择充电线-子类实现
    // 选择手机-子类实现
    // 给手机充电-父类实现

    /**
     * 模板方法,使用final不让子类去覆盖
     */
    final void charge() {
        String chargingLine;
        // 如果子类中将执行默认的chooseChargingLine()标记稍微false,则执行子类重写后的方法
        if (!hookChooseChargingLine()) {
            chargingLine = chooseChargingLine();
        } else {
            chargingLine = defaultChargingLine();
        }
        String phone = choosePhone();
        soak(chargingLine, phone);
    }

    /**
     * 选择充电线
     *
     * @return 充电线类型
     */
    abstract String chooseChargingLine();

    /**
     * 选择手机
     *
     * @return 手机型号
     */
    abstract String choosePhone();

    /**
     * 充电
     */
    public void soak(String chargingLine, String phone) {
        log.info("使用{}给{}充电", chargingLine, phone);
    }

    /**
     * chooseChargingLine()方法的钩子方法,默认返回TRUE
     *
     * @return 是否执行执行默认的chooseChargingLine()方法
     */
    boolean hookChooseChargingLine() {
        return Boolean.TRUE;
    }

    /**
     * 默认的充电方式
     *
     * @return 默认的充电线
     */
    public String defaultChargingLine() {
        log.info("使用默认的充电线-无线充电");
        return "无线充电";
    }
}
