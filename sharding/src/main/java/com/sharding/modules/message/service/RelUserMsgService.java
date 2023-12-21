package com.sharding.modules.message.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sharding.modules.message.domain.RelUserMsg;

/**
 * @author golf
 */
public interface RelUserMsgService extends IService<RelUserMsg> {

    /**
     * 批量新增
     *
     * @param num 新增数量
     */
    void batchAdd(Integer num);

    /**
     * 根据用户id更新状态
     *
     * @param userId 用户id
     */
    void updateByUserId(Long userId);
}
