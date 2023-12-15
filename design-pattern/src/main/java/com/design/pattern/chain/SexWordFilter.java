package com.design.pattern.chain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 涉黄拦截
 *
 * @author golf
 * @date 2023/12/14 19:57
 */
@Slf4j
@AllArgsConstructor
@Service
public class SexWordFilter implements SensitiveWordFilter {
    private final SensitiveWordFilterChain sensitiveWordFilterChain;
    private static final String SEX_WORLD = "黄色";

    @PostConstruct
    public void init() {
        sensitiveWordFilterChain.addFilter(this);
    }

    @Override
    public boolean doFilter(String message) {
        boolean legal = true;
        if (message.contains(SEX_WORLD)) {
            legal = false;
            log.warn("消息中包含黄色词汇,message:{}", message);
        }
        return legal;
    }
}
