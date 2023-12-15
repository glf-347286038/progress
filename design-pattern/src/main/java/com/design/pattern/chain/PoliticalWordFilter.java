package com.design.pattern.chain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 政治拦截
 *
 * @author golf
 * @date 2023/12/14 19:57
 */
@Slf4j
@AllArgsConstructor
@Service
public class PoliticalWordFilter implements SensitiveWordFilter {

    private final SensitiveWordFilterChain sensitiveWordFilterChain;
    private static final String POLITICAL_WORD = "造反";

    @PostConstruct
    public void init() {
        sensitiveWordFilterChain.addFilter(this);
    }

    @Override
    public boolean doFilter(String message) {
        boolean legal = true;
        if (message.contains(POLITICAL_WORD)) {
            legal = false;
            log.warn("消息中包含政治敏感词汇,message:{}", message);
        }
        return legal;
    }
}
