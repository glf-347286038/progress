package com.sharding.modules.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.modules.order.domain.entity.OrderDetail;
import com.sharding.modules.order.mapper.OrderDetailMapper;
import com.sharding.modules.order.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2022081615
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
        implements OrderDetailService {
}
