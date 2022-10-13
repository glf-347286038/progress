package com.glf.messagespringbootstarter.service.impl;

import com.glf.messagespringbootstarter.service.MessageService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: golf
 * @Date: 2022/8/18 16:44
 */
@Slf4j
public class MessageServiceImpl implements MessageService {
    private final String accessKeyId;
    private final String accessKeySecret;

    public MessageServiceImpl(String accessKeyId, String accessKeySecret) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }


    @Override
    public void sendMessage(String phone, String signName, String templateCode, String data) {
        log.info("接入短信系统,accessKeyId:{},accessKeySecret:{}", accessKeyId, accessKeySecret);
        log.info("短信发送,phone:{},signName:{},templateCode:{},data:{}", phone, signName, templateCode, data);
    }
}
