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

    public static final ThreadLocal<Integer> TENANT_ID_THREAD_LOCAL = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 获取租户id信息
        Integer tenantId = Integer.valueOf(request.getHeader("tenantId"));
        DynamicDataSourceContextHolder.push("tenant_" + tenantId);
        TENANT_ID_THREAD_LOCAL.set(tenantId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        TENANT_ID_THREAD_LOCAL.remove();
    }
}
