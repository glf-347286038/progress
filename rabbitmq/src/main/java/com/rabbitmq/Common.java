package com.rabbitmq;

/**
 * @Author: golf
 * @Date: 2022/5/6 22:09
 */
public class Common {
    /**
     * message相关
     */
    public static final String EXCHANGE_NAME = "direct_test_exchange";
    public static final String ROUTING_KEY = "";
    public static final String ROUTING_KEY2 = "sms";


    /**
     * 订单相关
     */
    public static final String DIRECT_DELAY_QUEUE_NAME = "direct.delay.queue";
    public static final String DIRECT_DELAY_EXCHANGE_NAME = "direct_delay_exchange";
    public static final String DIRECT_DELAY_QUEUE_ROUTING_KEY = "delay";
}
