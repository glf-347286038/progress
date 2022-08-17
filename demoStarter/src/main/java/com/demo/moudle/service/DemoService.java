package com.demo.moudle.service;

import com.demo.config.DemoConfig;

/**
 * @Author: golf
 * @Date: 2022/8/17 13:42
 */
public class DemoService {
    private final DemoConfig demoConfig;

    public DemoService(DemoConfig demoConfig) {
        this.demoConfig = demoConfig;
    }

    public String test() {
        return String.format("%s%s", demoConfig.getId(), demoConfig.getName());
    }
}
