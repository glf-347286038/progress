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

        this.getStarrocks();

        DynamicDataSourceContextHolder.push("tenant_" + DynamicDataSourceChangeInterceptor.TENANT_ID_THREAD_LOCAL.get());
        SysUser sysUser2 = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserName, user.getUserName()));
        return sysUser;
    }


    private String getStarrocks(){
        // 获取当前线程连接1
        String s1 = DynamicDataSourceContextHolder.peek();
        // 切换为目标连接2
        // 切换为连接1
        DynamicDataSourceContextHolder.push("tenant_" + DynamicDataSourceChangeInterceptor.TENANT_ID_THREAD_LOCAL.get() + "_starrocks");
        return this.baseMapper.getStarrocks();
    }

}




