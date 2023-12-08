package com.sharding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 相关设置可以迁移到配置文件中，此处暂时写死
 *
 * @author golf
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 获取处理器个数
     */
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    /**
     * 核心线程数量大小
     */
    private static final int CORE_POOL_SIZE = CPU_COUNT << 1;

    /**
     * 线程池最大容纳线程数
     */
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT << 2;

    /**
     * 空闲线程存活时间
     */
    private static final int KEEP_ALIVE_TIME = 30;

    /**
     * 线程队列长度
     */
    private static final int QUEUE_LENGTH = 65535;

    @Primary
    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAXIMUM_POOL_SIZE);
        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        executor.setQueueCapacity(QUEUE_LENGTH);
        // 默认拒绝
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }


}
