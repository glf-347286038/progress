package com.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author lfgao
 */
@EnableAutoConfiguration
@ComponentScan
@SpringBootConfiguration
public class AnnotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnnotationApplication.class, args);
    }
}
