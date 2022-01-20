package com.annotation.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lfgao
 */
@Data
@ConfigurationProperties(prefix = "user")
@Component
public class User {
    /**
     * 姓名
     */
    private String name;
    /**
     * 身体
     */
    private List<String> body;
    /**
     * 母亲
     */
    private Mother mother;

    @Data
    static class Mother {
        /**
         * 姓名
         */
        private String name;
        /**
         * 年龄
         */
        private Integer age;
        /**
         * 母亲的父亲
         */
        private Father father;

        @Data
        static class Father {
            private String name;
        }
    }
}
