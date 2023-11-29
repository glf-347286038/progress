package com.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author golf
 * @date 2023/11/28 16:24
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
