package com.sharding.modules.order.domain.vo;

import com.sharding.modules.order.domain.entity.OrderDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author golf
 * @date 2023/12/18 14:01
 */
@Data
public class OrderPageVO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 订单详情信息list
     */
    private List<OrderDetail> orderDetailList;
}
