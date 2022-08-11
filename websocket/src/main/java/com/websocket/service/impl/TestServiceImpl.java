package com.websocket.service.impl;

import com.websocket.WebSocketServer;
import com.websocket.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: golf
 * @Date: 2022/8/4 16:26
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void sendMessage(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        WebSocketServer.sendInfo(message, "10");
        log.info("date:{}", date);
    }
}
