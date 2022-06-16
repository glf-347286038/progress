package com.base.test.delay.queue;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 消息接收类
 *
 * @author lfgao
 */
@Slf4j
@Data
public class Message implements Delayed {
    /**
     * 消息内容
     */
    private String body;
    /**
     * 到期时间,比如2022-05-20 09:00:00到期 用时间戳表示
     */
    private Long executeTime;

    /**
     * Date date1 = getDateByInterval(new Date(), -3, Calendar.HOUR)  获取当前时间三小时前
     * 获取指定间隔时间的日期
     *
     * @param date 日期 比如当前时间 new Date()
     * @param time 时间    3
     * @param unit 单位 {@link Calendar}
     * @return 期望时间
     */
    public static Date getDateByInterval(Date date, int time, int unit) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(unit, time);
        return calendar.getTime();
    }

    /**
     * 时间戳转指定格式
     *
     * @param time 时间戳
     * @return 日期
     */
    public static String formatOne(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(time);
    }

    public static void main(String[] args) {
        // 当前时间一分钟后
        Date executeTime = getDateByInterval(new Date(), 1, Calendar.MINUTE);

        log.info("到期时间-当前时间戳:" + (executeTime.getTime() - System.currentTimeMillis()));

        long s = TimeUnit.MINUTES.convert(executeTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        log.info("到期时间-当前时间戳:" + s);
    }

    /**
     * 获得延迟时间，用过期时间-当前时间
     *
     * @param unit 时间的单位
     * @return 剩余时间小于等于0表示已经到期  大于0表示元素未到期
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 用于比较延时，这是队列里元素的排序依据。
     * 当生产者线程调用 put 之类的方法加入元素时，会触发 Delayed 接口中的 compareTo 方法进行排序，也就是说队列中元素的顺序是按到期时间排序的，而非它们进入队列的顺序。
     * 排在队列头部的元素是最早到期的，越往后到期时间赿晚。
     *
     * @param o ss
     * @return 2
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }
}
