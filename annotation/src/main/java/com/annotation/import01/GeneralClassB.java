package com.annotation.import01;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * 普通类
 *
 * @author lfgao
 */
@Data
@Log4j2
public class GeneralClassB {
    public boolean check() {
        log.info("使用ImportSelectTor注解导入普通类成功,类名:{}", this.getClass().getName());
        return true;
    }
}
