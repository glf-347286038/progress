package com.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 自动装配类
 *
 * @Author: golf
 * @Date: 2022/8/17 10:50
 */
@EnableConfigurationProperties(DemoConfig.class)
@ConfigurationProperties(prefix = "demo")
public class DemoConfig {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoConfig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
