package com.dynamic.data.source.module.user.controller;

import com.common.web.domain.CommonResult;
import com.dynamic.data.source.module.user.domain.SysUser;
import com.dynamic.data.source.module.user.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author golf
 * @date 2024/1/19 13:59
 */
@RequiredArgsConstructor
@RequestMapping("/sysUser")
@RestController
public class SysUserController {
    private final SysUserService sysUserService;

    @PostMapping("/detail")
    public CommonResult<SysUser> detail(@RequestBody SysUser user) {
        return CommonResult.success(sysUserService.detail(user));
    }

    @PostMapping("/add")
    public void add(@RequestBody SysUser user) {
        sysUserService.save(user);
    }

}
