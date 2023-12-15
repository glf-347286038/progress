package com.design.pattern.chain;

/**
 * @author golf
 * @date 2023/12/14 19:48
 */
public interface SensitiveWordFilter {
    /**
     * 过滤消息
     *
     * @param message 消息
     * @return 过滤结果
     */
    boolean doFilter(String message);
}
