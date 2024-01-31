package com.dynamic.data.source.module.user.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dynamic.data.source.module.user.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author golf
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询starrocks
     *
     * @return 产品码
     */
    //@DS("starrocks")
    String getStarrocks();
}




