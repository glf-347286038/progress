package com.common.config;

import com.common.exception.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Golf
 * @date 2022/10/24 14:01
 */
@Configuration
public class CommonAuthConfiguration {
    @Bean
    GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
