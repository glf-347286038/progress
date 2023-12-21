package com.sharding.modules.message.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
class RelUserMsgServiceTest {

    @Autowired
    private RelUserMsgService relUserMsgService;

    @Test
    void batchAddTwo() {
        relUserMsgService.batchAddTwo(100000);
    }
}