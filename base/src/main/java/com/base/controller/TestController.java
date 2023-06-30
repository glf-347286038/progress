package com.base.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author golf
 * @date 2022/9/7 8:50
 */
@RequiredArgsConstructor
@RequestMapping("test")
@RestController
public class TestController {
    private final RedisTemplate<Object, Object> redisTemplate;

    /**
     * 服务端想客户端推送消息
     *
     * @param value 消息内容
     */
    @PostMapping("/redis")
    public void redis(String value) {
        redisTemplate.opsForValue().set("test", value);
    }

    /**
     * 服务端想客户端推送消息
     *
     * @param value 消息内容
     */
    @PostMapping("/getRedis")
    public String getRedis(String value) {
        return (String) redisTemplate.opsForValue().get(value);
    }

}
