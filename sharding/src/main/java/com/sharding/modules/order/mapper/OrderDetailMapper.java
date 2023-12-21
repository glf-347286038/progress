package com.sharding.modules.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.modules.order.domain.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author golf
 * @date 2023/11/28 16:24
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}
