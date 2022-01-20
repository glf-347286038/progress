package com.design.pattern.singleton;

import lombok.Data;

/**
 * 饿汉式单例模式
 * 这种方式比较常用,但是容易产生垃圾对象
 * 优点:没有加锁,执行效率高
 * 缺点:类加载时就初始化,浪费内存
 *
 * @author golf
 */
@Data
public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();
    private Integer code;
    private Object data;

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance(Object data) {
        hungrySingleton.setData(data);
        return hungrySingleton;
    }
}
