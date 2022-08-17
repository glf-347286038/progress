package com.demo.config;

import com.demo.moudle.service.DemoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: golf
 * @Date: 2022/8/17 11:22
 */
@Configuration
@ConditionalOnClass
@Import(DemoService.class)
public class DemoConfiguration {
    @Bean
    public DemoConfig demoConfig() {
        return new DemoConfig();
    }
}
