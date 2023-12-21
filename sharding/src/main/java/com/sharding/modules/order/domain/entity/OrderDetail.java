package com.sharding.modules.order.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情表
 *
 * @author golf
 */
@Accessors(chain = true)
@Data
@TableName(value = "order_detail")
public class OrderDetail implements Serializable {
    /**
     * 订单表主键
     */
    private Long id;
    /**
     * 订单表主键
     */
    private Long orderId;

    /**
     * key_name
     */
    private String keyName;

    /**
     * key-value
     */
    private String keyValue;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人id
     */
    private Integer updateBy;
}