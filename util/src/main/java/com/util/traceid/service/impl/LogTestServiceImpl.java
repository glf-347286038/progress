package com.util.traceid.service.impl;

import com.util.traceid.service.LogTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: golf
 * @Date: 2022/7/14 13:54
 */
@Slf4j
@Service
public class LogTestServiceImpl implements LogTestService {
    @Override
    public Integer methodOne(Integer num) {
        Integer result = num * num;
        log.info("{}的平方结果为:{}", num, result);
        return result;
    }

    @Override
    public Integer methodTwo(Integer num) {
        Integer result = num * num * num;
        log.info("{}的立方结果为：{}", num, result);
        return result;
    }

    @Override
    public Integer methodThree(Integer num) {
        int result = num + 100;
        log.info("{}+100的结果为:{}", num, result);

        if (result > 120) {
            log.warn("{}加上100后大于120", num);
        }

        if (result > 150) {
            log.error("{}加上100后大于150", num);
        }
        return result;
    }
}
