package com.sharding.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.domain.dto.OrderPageDTO;
import com.sharding.domain.entity.Order;
import com.sharding.domain.entity.OrderDetail;
import com.sharding.domain.vo.OrderVo;
import com.sharding.mapper.OrderMapper;
import com.sharding.service.OrderDetailService;
import com.sharding.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author golf
 * @date 2023/11/28 16:33
 */
@RequiredArgsConstructor
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    private final OrderDetailService orderDetailService;

    private static final String URL = "jdbc:mysql://47.98.149.207:3306/test?serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
    Connection connection = null;
    PreparedStatement psOne;
    PreparedStatement psTwo;
    ResultSet rs = null;

    @SuppressWarnings("all")
    public void coon() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, "root", "158d3e483dc248552");
    }

    @Override
    public OrderVo detail(Long id) {
        Order order = this.getById(id);
        List<OrderDetail> orderDetailList = orderDetailService.list(new LambdaQueryWrapper<OrderDetail>()
                .eq(OrderDetail::getOrderId, id));
        return new OrderVo().setOrder(order).setOrderDetails(orderDetailList);
    }

    @SuppressWarnings("all")
    @Override
    public void batchAdd(Integer num) {
        long start = System.currentTimeMillis();
        String sqlOrder = "insert into orders(id,order_no) VALUES (?,?)";
        String sqlOrderDetail = "insert into order_detail(id,order_id,key_name,key_value) VALUES (?,?,?,?)";
        Snowflake snowflake = new Snowflake(1, 1);
        Snowflake snowflakeTwo = new Snowflake(1, 1);

        try {
            coon();
            connection.setAutoCommit(false);
            psOne = connection.prepareStatement(sqlOrder);
            psTwo = connection.prepareStatement(sqlOrderDetail);
            int detailCount = 1;
            for (int i = 1; i <= num; i++) {
                Long orderId = snowflake.nextId();
                psOne.setObject(1, orderId);
                psOne.setObject(2, "no" + orderId);
                psOne.addBatch();
                if (i % 1000 == 0) {
                    psOne.executeBatch();
                    psOne.clearBatch();
                }

                for (OrderKeyNameEnum enums : OrderKeyNameEnum.values()) {
                    psTwo.setObject(1, snowflakeTwo.nextId());
                    psTwo.setObject(2, orderId);
                    psTwo.setObject(3, enums.getName());
                    psTwo.setObject(4, UUID.randomUUID().toString());
                    psTwo.addBatch();
                    detailCount++;
                }
                if (detailCount % 1000 == 0) {
                    psTwo.executeBatch();
                    psTwo.clearBatch();
                    detailCount = 0;
                }
            }
            psOne.executeBatch();
            psTwo.executeBatch();
            connection.commit();
            psTwo.clearBatch();
            psOne.clearBatch();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psOne != null) {
                    psOne.close();
                }
                if (psTwo != null) {
                    psTwo.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(num * 50 + "条数据插入用时" + (System.currentTimeMillis() - start) + " 毫秒");

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void batchAddTwo(Integer num) {
        Snowflake snowflake = new Snowflake(1, 1);
        List<Order> orderList = new ArrayList<>();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Long orderId = snowflake.nextId();
            Order order = new Order().setId(orderId).setOrderNo("no" + orderId);
            orderList.add(order);

            for (OrderKeyNameEnum enums : OrderKeyNameEnum.values()) {
                Long orderDetailId = snowflake.nextId();
                OrderDetail orderDetail = new OrderDetail().setId(orderDetailId).setOrderId(orderId)
                        .setKeyName(enums.getName()).setKeyValue(UUID.randomUUID().toString());
                orderDetailList.add(orderDetail);
            }
        }
        this.saveBatch(orderList);
        orderDetailService.saveBatch(orderDetailList);
    }

    @Override
    public IPage<Order> page(Page<Order> page, OrderPageDTO pageDTO) {
        IPage<Order> iPage = new Page<>(page.getCurrent(), page.getSize());
        Long total = baseMapper.countPage(pageDTO);
        if (total > 0) {
            iPage.setTotal(total);
            List<Order> orderList = baseMapper.page(iPage.offset(), iPage.getSize(), pageDTO);
            iPage.setRecords(orderList);
        }
        return iPage;
    }

    @Getter
    public enum OrderKeyNameEnum {
        /**
         * A
         */
        A("A"),
        A1("A1"),
        B("B"),
        B1("B1"),
        C("C"),
        C1("C1"),
        D("D"),
        D1("D1"),
        E("E"),
        E1("E1"),
        F("F"),
        F1("F1"),
        G("G"),
        G1("G1"),
        H("H"),
        H1("H1"),
        I("I"),
        I1("I1"),
        J("J"),
        J1("J1"),
        K("K"),
        K1("K1"),
        L("L"),
        L1("L1"),
        M("M"),
        M1("M1"),
        N("N"),
        N1("N1"),
        O("O"),
        O1("O1"),
        P("P"),
        P1("P1"),
        Q("Q"),
        Q1("Q1"),
        R("R"),
        R1("R1"),
        S("S"),
        S1("S1"),
        T("T"),
        T1("T1"),
        U("U"),
        U1("U1"),
        V("V"),
        V1("V1"),
        W("W"),
        W1("W1"),
        X("X"),
        X1("X1"),
        Y("Y"),
        Z("Z"),
        ;
        private final String name;

        OrderKeyNameEnum(String name) {
            this.name = name;
        }
    }
}
