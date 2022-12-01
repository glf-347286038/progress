package com.base.concurrent;

import com.base.concurrent.lock.LockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author golf
 * @date 2022/12/1 10:47
 */
@RequiredArgsConstructor
@RequestMapping("concurrent")
@RestController
public class ConcurrentController {
    private final LockService lockService;
    @GetMapping("testDeadLock")
    public String testDeadLock(){
        lockService.deadLock();
        return "success";
    }
}
