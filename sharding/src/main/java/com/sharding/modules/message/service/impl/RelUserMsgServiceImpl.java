package com.sharding.modules.message.service.impl;


import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.modules.message.domain.RelUserMsg;
import com.sharding.modules.message.mapper.RelUserMsgMapper;
import com.sharding.modules.message.service.RelUserMsgService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author golf
 */
@Slf4j
@Service
public class RelUserMsgServiceImpl extends ServiceImpl<RelUserMsgMapper, RelUserMsg>
        implements RelUserMsgService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void batchAdd(Integer num) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<RelUserMsg> list = new ArrayList<>(num);
        Snowflake snowflake = new Snowflake(1, 1);
        for (int i = 0; i < num; i++) {
            RelUserMsg relUserMsg = new RelUserMsg();
            relUserMsg.setId(snowflake.nextId());
            relUserMsg.setUserId((long) (i % 100));
            relUserMsg.setMsgId((long) (i % 50));
            list.add(relUserMsg);
            if (list.size() == 1000) {
                this.saveBatch(list);
                list.clear();
            }
        }
        this.saveBatch(list);
        log.info("RelUserMsgServiceImpl#batchAdd 执行时间{}", stopWatch);
    }

    @Override
    public void updateByUserId(Long userId) {
        baseMapper.updateByUserId(userId);
    }

    @SuppressWarnings("all")
    @SneakyThrows
    @Override
    public void batchAddTwo(Integer num) {
        StopWatch stopWatch = new StopWatch("1");
        stopWatch.start();
        String sql = "insert into rel_user_msg(id,user_id,msg_id) VALUES (?,?,?)";
        Snowflake snowflake = new Snowflake(1, 1);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://47.98.149.207:3306/test?serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root", "158d3e483dc2");
        connection.setAutoCommit(false);
        PreparedStatement psOne = connection.prepareStatement(sql);

        for (int i = 1; i <= num; i++) {
            psOne.setObject(1, snowflake.nextId());
            psOne.setObject(2, i % 100);
            psOne.setObject(3, i % 50);
            psOne.addBatch();
            if (i % 1000 == 0) {
                psOne.executeBatch();
                psOne.clearBatch();
            }
        }
        psOne.executeBatch();
        connection.commit();
        psOne.clearBatch();
        psOne.close();
        connection.close();
        stopWatch.stop();
        log.info("增加消息时间：{} 秒", stopWatch.getTotalTimeSeconds());
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("1");
        stopWatch.start();
        Thread.sleep(1000);

        stopWatch.stop();

        System.out.println(stopWatch);
    }
}




