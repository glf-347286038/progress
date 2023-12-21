package com.sharding.modules.order.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author golf
 * @date 2023/11/28 16:25
 */
@Accessors(chain = true)
@Data
@TableName(value = "orders")
public class Order {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 订单号
     */
    private String orderNo;

    private Date createTime;
    private Long createBy;
    private Date updateTime;
    private Long updateBy;
}