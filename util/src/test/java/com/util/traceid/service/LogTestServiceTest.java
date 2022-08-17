package com.util.traceid.service;

import com.demo.moudle.service.DemoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: golf
 * @Date: 2022/8/17 14:02
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
class LogTestServiceTest {

    @Autowired
    private DemoService demoService;

    @Test
    void methodOne() {
        String s = demoService.test();
        log.info("测试{}", s);
    }
}
