package com.dynamic.data.source.module.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dynamic.data.source.module.user.domain.SysUser;

/**
 * 用户service
 *
 * @author golf
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 查询详情
     *
     * @param user 用户
     * @return 用户
     */
    SysUser detail(SysUser user);
}
