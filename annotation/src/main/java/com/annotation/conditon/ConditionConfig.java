package com.annotation.conditon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author lfgao
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public Os windows() {
        Os windows = new Os();
        windows.setName("Windows");
        return windows;
    }

    @Bean
    @Conditional({LinuxCondition.class})
    public Os linux() {
        Os linux = new Os();
        linux.setName("Linux");
        return linux;
    }
}
