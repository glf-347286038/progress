package com.sharding.modules.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sharding.modules.order.domain.dto.OrderPageDTO;
import com.sharding.modules.order.domain.entity.Order;
import com.sharding.modules.order.domain.vo.OrderPageVO;
import com.sharding.modules.order.domain.vo.OrderVo;

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

    /**
     * 分页
     *
     * @param page   分页信息
     * @param pageDTO 查询参数
     * @return 分页信息
     */
    IPage<OrderPageVO> page(Page<Order> page, OrderPageDTO pageDTO);
}
