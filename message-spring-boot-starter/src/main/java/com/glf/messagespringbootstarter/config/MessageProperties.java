package com.glf.messagespringbootstarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件属性类 XxxProperties
 *
 * @Author: golf
 * @Date: 2022/8/18 15:13
 */
@Data
@ConfigurationProperties(prefix = "message")
public class MessageProperties {
    /**
     * 访问Id、账号
     */
    private String accessKeyId;
    /**
     * 访问凭证,即密码
     */
    private String accessKeySecret;
}
