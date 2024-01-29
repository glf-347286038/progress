package com.dynamic.data.source.config;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Set;

/**
 * @author golf
 * @date 2024/1/19 15:27
 */
@RequiredArgsConstructor
@Component
public class DataSourceChangeProvider {

    private final DataSource dataSource;
    private final DefaultDataSourceCreator defaultDataSourceCreator;
    private final CustomerConfig customerConfig;

    /**
     * 增加数据源
     *
     * @param tenantConfig 租户配置
     */
    public void addDataSource(CustomerConfig.TenantConfig tenantConfig) {
        DynamicRoutingDataSource dynamicRoutingDataSource = (DynamicRoutingDataSource) dataSource;
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        Integer tenantId = tenantConfig.getTenantId();
        String dsName = "tenant_" + tenantId;
        dataSourceProperty.setPoolName(dsName);
        dataSourceProperty.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceProperty.setUrl(tenantConfig.getJdbcUrl());
        dataSourceProperty.setUsername(tenantConfig.getJdbcUserName());
        dataSourceProperty.setPassword(tenantConfig.getJdbcPassword());
        DataSource dataSource2 = defaultDataSourceCreator.createDataSource(dataSourceProperty);
        dynamicRoutingDataSource.addDataSource(dsName, dataSource2);
    }

    @PostConstruct
    public void initDataSourceAll() {
        Set<CustomerConfig.TenantConfig> tenantConfigSet = customerConfig.getTenantConfigSet();
        for (CustomerConfig.TenantConfig tenantConfig : tenantConfigSet) {
            this.addDataSource(tenantConfig);
        }
    }

}
