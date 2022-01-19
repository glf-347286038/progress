package com.annotation.conditon.impl;

import com.annotation.conditon.ConditionService;
import com.annotation.conditon.Os;
import org.springframework.stereotype.Service;

/**
 * 实现类
 *
 * @author lfgao
 */
@Service
public class ConditionServiceImpl implements ConditionService {

    private final Os os;

    public ConditionServiceImpl(Os os) {
        this.os = os;
    }

    @Override
    public Os getOs() {
        return os;
    }
}
