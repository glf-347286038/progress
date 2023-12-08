package com.sharding.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.domain.entity.OrderDetail;
import com.sharding.mapper.OrderDetailMapper;
import com.sharding.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2022081615
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
        implements OrderDetailService {
}
