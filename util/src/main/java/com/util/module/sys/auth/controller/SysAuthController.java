package com.util.module.sys.auth.controller;

import com.util.module.sys.auth.model.SysAuth;
import com.util.module.sys.auth.service.SysAuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author golf
 * @date 2022/9/9 15:27
 */
@AllArgsConstructor
@RequestMapping("sysAuth")
@RestController
public class SysAuthController {
    private final SysAuthService sysAuthService;

    @GetMapping("list")
    public List<SysAuth> list() {
        return sysAuthService.listSysAuth("");
    }

    @GetMapping("get")
    public SysAuth getSysAuth(SysAuth sysAuth) {
        return sysAuthService.getSysAuth(sysAuth);
    }
}
