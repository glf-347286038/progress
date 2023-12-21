package com.sharding.modules.order.domain.vo;

import com.sharding.modules.order.domain.entity.Order;
import com.sharding.modules.order.domain.entity.OrderDetail;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author golf
 * @date 2023/12/7 13:36
 */
@Accessors(chain = true)
@Data
public class OrderVo {
    private Order order;
    private List<OrderDetail> orderDetails;
}
