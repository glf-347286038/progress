package com.dynamic.data.source.module.user.service.impl;


import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dynamic.data.source.config.DynamicDataSourceChangeInterceptor;
import com.dynamic.data.source.module.user.domain.SysUser;
import com.dynamic.data.source.module.user.mapper.SysUserMapper;
import com.dynamic.data.source.module.user.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author golf
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Override
    public SysUser detail(SysUser user) {

        SysUser sysUser = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserName, user.getUserName()));

        DynamicDataSourceContextHolder.push("tenant_" + DynamicDataSourceChangeInterceptor.TENANT_ID_THREAD_LOCAL.get() + "_starrocks");
        String s = this.baseMapper.getStarrocks();

        DynamicDataSourceContextHolder.push("tenant_" + DynamicDataSourceChangeInterceptor.TENANT_ID_THREAD_LOCAL.get());
        SysUser sysUser2 = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserName, user.getUserName()));
        return sysUser;
    }
}




