package com.websocket.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: golf
 * @Date: 2022/8/4 16:24
 */
@AllArgsConstructor
@Controller
@RequestMapping("/api/test")
public class TestController {
    private final TestService testService;

    /**
     * 启动页面
     *
     * @return 启动页面
     */
    @RequestMapping("index")
    public String index() {
        return "/index";
    }

    /**
     * 服务端想客户端推送消息
     *
     * @param message 消息内容
     */
    @PostMapping("/pushToWeb")
    public void pushToWeb(String message) {
        testService.sendMessage(message);
    }


}
