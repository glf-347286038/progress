package com.util.module.sys.auth.service;

import com.util.module.sys.auth.model.SysAuth;

import java.util.List;

/**
 * @author golf
 * @date 2022/9/9 10:07
 */
public interface SysAuthService {
    /**
     * 列表查询
     *
     * @param authPath 权限路径
     * @return 权限列表
     */
    List<SysAuth> listSysAuth(String authPath);

    /**
     * 查询单个路径权限
     *
     * @param sysAuth 权限
     * @return 路径
     */
    SysAuth getSysAuth(SysAuth sysAuth);
}
