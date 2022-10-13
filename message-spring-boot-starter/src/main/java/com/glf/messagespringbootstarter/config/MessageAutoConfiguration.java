package com.glf.messagespringbootstarter.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 注解@EnableConfigurationProperties的作用是使@ConfigurationProperties注解生效
 *
 * @Author: golf
 * @Date: 2022/8/18 15:46
 */
@Configuration
@EnableConfigurationProperties({MessageProperties.class})
public class MessageAutoConfiguration {


}
