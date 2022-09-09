package com.util.module.sys.auth.service;

import com.util.module.sys.auth.model.SysAuth;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
class SysAuthServiceTest {
    @Autowired
    private SysAuthService sysAuthService;

    @Test
    void listSysAuth() {

        Runnable runnable1 = () -> {
            try {
                List<SysAuth> sysAuthServices = sysAuthService.listSysAuth(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.setName("线程一");

        Runnable runnable2 = () -> {
            try {
                List<SysAuth> sysAuthServices = sysAuthService.listSysAuth(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread thread2 = new Thread(runnable2);
        thread2.setName("线程二");

        thread1.start();
        thread2.start();

        Assert.assertTrue("通过", true);
    }
}