package com.dynamic.data.source.config;

import com.common.exception.ServiceException;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author golf
 * @date 2024/1/19 15:34
 */


@ConfigurationProperties(prefix = "customer")
@Configuration
@Data
public class CustomerConfig {
    /**
     * 租户信息
     */
    private Set<TenantConfig> tenantConfigSet = new HashSet<>();

    @Data
    public static class TenantConfig {
        /**
         * 租户
         */
        private Integer tenantId;
        /**
         * 数据库连接地址
         */
        private String jdbcUrl;
        /**
         * 数据库用户名
         */
        private String jdbcUserName;
        /**
         * 数据库密码
         */
        private String jdbcPassword;
    }

    /**
     * 获取租户配置信息
     *
     * @param tenantId tenantId
     * @return 租户配置信息
     */
    public TenantConfig getTenantConfigByTenantId(Integer tenantId) {
        if (tenantId == null) {
            throw new ServiceException("tenantId 为空!");
        }
        Map<Integer, TenantConfig> tenantConfigMap = this.getTenantConfigSet().stream().collect(Collectors.toMap(CustomerConfig.TenantConfig::getTenantId, Function.identity(), (k1, k2) -> k2));
        return Optional.ofNullable(tenantConfigMap.get(tenantId)).orElseThrow(() -> new ServiceException(String.format("Tenant %s 未配置", tenantId)));
    }
}
