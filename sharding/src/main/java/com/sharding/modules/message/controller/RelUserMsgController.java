package com.sharding.modules.message.controller;

import com.common.web.domain.CommonResult;
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
    public CommonResult<String> batchAdd(Integer num) {
        relUserMsgService.batchAdd(num);
        return CommonResult.success();
    }

    @PostMapping("/batchAddTwo")
    public CommonResult<String> batchAddTwo(Integer num) {
        relUserMsgService.batchAddTwo(num);
        return CommonResult.success();
    }

    @PostMapping("/updateByUserId")
    public CommonResult<String> updateByUserId(Long userId) {
        relUserMsgService.updateByUserId(userId);
        return CommonResult.success();
    }
}

