package com.design.pattern.chain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author golf
 * @date 2023/12/15 13:54
 */
@AllArgsConstructor
@Service
public class SensitiveWordFilterChain {
    private final List<SensitiveWordFilter> filters = new ArrayList<>();

    /**
     * 添加链
     *
     * @param filter 链节点
     */
    public void addFilter(SensitiveWordFilter filter) {
        this.filters.add(filter);
    }

    /**
     * 链式拦截
     *
     * @param message 消息
     * @return 拦截结果
     */
    public boolean filter(String message) {
        for (SensitiveWordFilter filter : filters) {
            if (!filter.doFilter(message)) {
                return false;
            }
        }
        return true;
    }
}
