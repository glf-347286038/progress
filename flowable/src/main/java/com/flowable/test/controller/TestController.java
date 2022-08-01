package com.flowable.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: golf
 * @Date: 2022/7/28 16:11
 */
@Slf4j
@RequestMapping("test")
@RestController
public class TestController {
    @GetMapping("hello")
    public String testOne() {
        return "测";
    }
}
