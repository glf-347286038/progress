package com.dynamic.data.source.config;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 动态数据源-拦截器模式-需要自定义规则
 *
 * @author golf
 * @date 2024/1/19 17:23
 */
@Slf4j
public class DynamicDataSourceChangeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 获取租户id信息
        String tenantId = request.getHeader("tenantId");
        DynamicDataSourceContextHolder.push("tenant_" + tenantId);
        return true;
    }

}
