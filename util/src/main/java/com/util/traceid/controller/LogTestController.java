package com.util.traceid.controller;

import com.util.traceid.pojo.MessageDTO;
import com.util.traceid.service.LogTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: golf
 * @Date: 2022/7/13 10:58
 */
@RequestMapping("test")
@RestController
@Slf4j
public class LogTestController {

    private final LogTestService logTestService;

    public LogTestController(LogTestService logTestService) {
        this.logTestService = logTestService;
    }

    @PostMapping("logTest")
    public String logTest(@RequestBody @Validated MessageDTO messageDTO) {

        Integer resultOne = logTestService.methodOne(messageDTO.getNum());

        Integer resultTwo = logTestService.methodTwo(messageDTO.getNum());

        Integer resultThree = logTestService.methodThree(messageDTO.getNum());

        return "数字平方值为:" + resultOne + "立方结果为:" + resultTwo + "加100的结果为:" + resultThree;
    }
}
