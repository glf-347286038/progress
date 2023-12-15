package com.design.pattern.chain;


import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
class SensitiveWordFilterTest {
    @Autowired
    private SensitiveWordFilterChain sensitiveWordFilterChain;

    @Test
    void doFilter() {
        String message = "尊敬的用户,您的会员将在2023年12月24日到期";
        boolean legal = sensitiveWordFilterChain.filter(message);

        String message2 = "这是一条黄色短信";
        boolean legal2 = sensitiveWordFilterChain.filter(message2);

        String message3 = "革命无罪,造反有理";
        boolean legal3 = sensitiveWordFilterChain.filter(message3);

        Assert.assertTrue("消息正常", legal);
        Assert.assertTrue("消息正常", legal2);
        Assert.assertTrue("消息正常", legal3);
    }
}