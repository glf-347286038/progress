package com.sharding.modules.message.controller;

import com.sharding.modules.message.service.RelUserMsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author golf
 * @date 2023/12/20 16:44
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/relUserMsg")
public class RelUserMsgController {
    private final RelUserMsgService relUserMsgService;

    @PostMapping("/batchAdd")
    public void batchAdd(Integer num) {
        relUserMsgService.batchAdd(num);
    }

    @PostMapping("/updateByUserId")
    public void updateByUserId(Long userId) {
        relUserMsgService.updateByUserId(userId);
    }
}

