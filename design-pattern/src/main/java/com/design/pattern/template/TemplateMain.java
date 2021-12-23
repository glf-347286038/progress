package com.design.pattern.template;

/**
 * @author glf
 * @Date: 2021/12/23 23:37
 */
public class TemplateMain {
    public static void main(String[] args) {
        AbstractCharge androidCharge = new AndroidCharge();
        androidCharge.charge();

        AbstractCharge iosCharge = new IosCharge();
        iosCharge.charge();
    }
}
