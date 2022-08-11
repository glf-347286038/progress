package com.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: golf
 * @Date: 2022/8/4 15:46
 */
@Component
@Slf4j
@ServerEndpoint("/api/pushMessage/{userId}")
public class WebSocketServer {
    /**
     * 用来记录当前在线连接数。应该把它设计成线程安全的
     */
    public static int ON_LINE_COUNT = 0;
    /**
     * 用来存放每个客户端对应的webSocket对象
     */
    public static ConcurrentMap<String, WebSocketServer> WEB_SOCKET_MAP = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    public Session session;
    /**
     * 接收userId
     */
    public String userId = "";

    /**
     * 发送自定义消息
     *
     * @param message 消息内容
     * @param userId  用户id
     */
    public static void sendInfo(String message, String userId) {
        log.info("发送消息到:{},消息内容:{}", userId, message);
        if (message != null && message.length() > 0 && WEB_SOCKET_MAP.containsKey(userId)) {
            WEB_SOCKET_MAP.get(userId).sendMessage(message);
        } else {
            log.error("Id:{}的用户不在线", userId);
        }
    }

    /**
     * 获得此时的
     * 在线人数
     *
     * @return 在线人数
     */
    public static synchronized int getOnlineCount() {
        return ON_LINE_COUNT;
    }

    /**
     * 在线人数加一
     */
    public static synchronized void addOnLineCount() {
        WebSocketServer.ON_LINE_COUNT++;
    }

    /**
     * 在线人数减一
     */
    public static synchronized void subOnlineCount() {
        WebSocketServer.ON_LINE_COUNT++;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;
        if (WEB_SOCKET_MAP.containsKey(userId)) {
            WEB_SOCKET_MAP.remove(userId);
            WEB_SOCKET_MAP.put(userId, this);
        } else {
            WEB_SOCKET_MAP.put(userId, this);
            addOnLineCount();
        }
        log.info("用户连接:{},当前在线人数为:{}", userId, getOnlineCount());
        sendMessage("连接成功");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (WEB_SOCKET_MAP.containsKey(userId)) {
            WEB_SOCKET_MAP.remove(userId);
            subOnlineCount();
        }
        log.info("用户:{}退出，当前在线人数为:{}", userId, getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 消息内容
     * @param session 用户会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户:{}发送的消息内容:{}", userId, message);
        // 可以群发消息
        // 消息保存到数据库、redis
        if (message != null && message.length() > 0) {
            // 解析发送的报文
            JSONObject jsonpObject = JSON.parseObject(message);
            // 追加发送人(防止串改)
            jsonpObject.put("fromUserId", this.userId);
            String toUserId = jsonpObject.getString("toUserId");
            // 传给对应toUserId用户的webSocket
            if (toUserId != null && toUserId.length() > 0 && WEB_SOCKET_MAP.containsKey(toUserId)) {
                WEB_SOCKET_MAP.get(toUserId).sendMessage(message);
            } else {
                log.error("请求的userId:{}不在该服务器上", toUserId);
            }
        }
    }

    /**
     * @param session 会话信息
     * @param error   异常
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:{},原因:{}", userId, error.getMessage());
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     *
     * @param message 消息内容
     */
    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("消息推送失败", e);
        }
    }

}
