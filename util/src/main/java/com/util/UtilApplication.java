package com.util;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用于通用工具开发
 *
 * @author golf
 */
@MapperScan({"com.util.module.*.mapper","com.util.module.**.mapper","com.util.module.***.mapper"})
@SpringBootApplication
public class UtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilApplication.class, args);
    }

}
