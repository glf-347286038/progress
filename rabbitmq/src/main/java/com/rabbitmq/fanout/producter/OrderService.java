package com.rabbitmq.fanout.producter;

/**
 * @Author: golf
 * @Date: 2022/5/3 0:44
 */
public interface OrderService {
    /**
     * 生成订单
     *
     * @param userId 用户id
     * @param num    商品数目
     */
    void saveOrder(Long userId, Integer num);
}
