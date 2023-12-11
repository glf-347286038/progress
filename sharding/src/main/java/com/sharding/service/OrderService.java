package com.sharding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sharding.domain.entity.Order;
import com.sharding.domain.vo.OrderVo;

/**
 * @author golf
 * @date 2023/11/28 16:28
 */
public interface OrderService extends IService<Order> {

    /**
     * 获取订单详情
     *
     * @param id 主键
     * @return 订单VO
     */
    OrderVo detail(Long id);

    /**
     * 批量新增
     *
     * @param num 数量
     */
    void batchAdd(Integer num);

    /**
     * 批量新增
     *
     * @param num 数量
     */
    void batchAddTwo(Integer num);
}
