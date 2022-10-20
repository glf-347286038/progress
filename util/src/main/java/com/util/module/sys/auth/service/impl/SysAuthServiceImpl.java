package com.util.module.sys.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.util.module.sys.auth.mapper.SysAuthMapper;
import com.util.module.sys.auth.model.SysAuth;
import com.util.module.sys.auth.service.SysAuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author golf
 * @date 2022/9/9 10:07
 */
@AllArgsConstructor
@Slf4j
@Service
public class SysAuthServiceImpl implements SysAuthService {

    private final SysAuthMapper sysAuthMapper;
    private final RedisTemplate<String, Object> redisTemplate;
    @Override
    public List<SysAuth> listSysAuth(String authPath) {
        QueryWrapper<SysAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(authPath != null, SysAuth::getAuthPath, authPath);
        return sysAuthMapper.selectList(queryWrapper);
    }

    @Override
    public SysAuth getSysAuth(SysAuth sysAuth) {
        QueryWrapper<SysAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(sysAuth.getId() != null, SysAuth::getId, sysAuth.getId());
        return sysAuthMapper.selectOne(queryWrapper);
    }
}
