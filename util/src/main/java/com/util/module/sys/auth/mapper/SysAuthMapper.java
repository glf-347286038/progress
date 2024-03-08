package com.util.module.sys.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.util.module.sys.auth.model.SysAuth;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author golf
 * @date 2022/9/9 10:00
 */
@Mapper
public interface SysAuthMapper extends BaseMapper<SysAuth> {

}
