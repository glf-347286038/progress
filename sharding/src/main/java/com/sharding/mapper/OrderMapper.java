package com.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sharding.domain.dto.OrderPageDTO;
import com.sharding.domain.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author golf
 * @date 2023/11/28 16:24
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 分页总数
     *
     * @param pageDTO 查询参数
     * @return 分页总数量
     */
    Long countPage(@Param("pageDTO") OrderPageDTO pageDTO);

    /**
     * 分页
     *
     * @param offset  偏移量
     * @param size    分页大小
     * @param pageDTO 查询参数
     * @return 分页
     */
    List<Order> page(@Param("offset") Long offset, @Param("size") Long size, @Param("pageDTO") OrderPageDTO pageDTO);
}
