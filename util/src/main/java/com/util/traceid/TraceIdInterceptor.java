package com.util.traceid;

import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * traceId生成拦截器
 *
 * @Author: golf
 * @Date: 2022/7/5 9:27
 */
@Configuration
public class TraceIdInterceptor implements HandlerInterceptor {
    private static final String TRACE_ID = "traceId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String traceId = request.getHeader(TRACE_ID);
        if (traceId == null) {
            // todo traceId生成规则优化 机器ip+时间戳+pid号+流水号
            traceId = UUID.randomUUID().toString().replace("-", "");
        }
        MDC.put(TRACE_ID, traceId);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 整个MVC流程视图渲染结束后删除(threadLocal原因)
        MDC.remove(TRACE_ID);
    }
}
