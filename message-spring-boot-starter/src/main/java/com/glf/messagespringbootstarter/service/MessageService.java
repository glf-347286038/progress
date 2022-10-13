package com.glf.messagespringbootstarter.service;

/**
 * @Author: golf
 * @Date: 2022/8/18 16:24
 */
public interface MessageService {
    /**
     * 发送消息
     *
     * @param phone        要发送的手机号
     * @param signName     短信签名-在短信控制台中找
     * @param templateCode 短信模板
     * @param data         要发送的内容
     */
    void sendMessage(String phone, String signName, String templateCode, String data);
}
