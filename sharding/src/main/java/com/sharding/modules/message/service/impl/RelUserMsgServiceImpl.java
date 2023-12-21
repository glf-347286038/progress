package com.sharding.modules.message.service.impl;


import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.modules.message.domain.RelUserMsg;
import com.sharding.modules.message.mapper.RelUserMsgMapper;
import com.sharding.modules.message.service.RelUserMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

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
}




