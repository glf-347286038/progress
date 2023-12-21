package com.sharding.modules.message.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.modules.message.domain.RelUserMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author golf
 */
@Mapper
public interface RelUserMsgMapper extends BaseMapper<RelUserMsg> {
    /**
     * 根据用户id更新状态
     *
     * @param userId 用户id
     */
    void updateByUserId(@Param("userId") Long userId);
}




