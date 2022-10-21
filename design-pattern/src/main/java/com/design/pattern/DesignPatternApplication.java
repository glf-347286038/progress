package com.design.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author golf
 * @date 2022/10/20 15:43
 */
@SpringBootApplication
@EnableAsync
public class DesignPatternApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);
    }
}
