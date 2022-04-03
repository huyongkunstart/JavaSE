package com.hu.java6;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * JDK8中新日期时间API
 * @author hu
 * @create 2021-12-03 9:40
 */
public class JDK8DateTime {
    @Test
    public void test1(){
        //now():获取当前的日期，时间，日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():
        LocalDateTime of1 = LocalDateTime.of(2019, 10, 9, 10, 45, 23);
        System.out.println(of1);
        System.out.println("****************************************");
        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek().getValue());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());
        System.out.println("****************************************");
        //体现不可变性
        //withXxx()：设置相关的属性
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println("****************************************");
        //加属性
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println("****************************************");
        //减属性
        LocalDateTime localDateTime3 = localDateTime.minusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
    }

    /**
     * instant的使用
     */
    @Test
    //now():获取本初子午线对应的标准时间
    public void test2(){
        Instant instant = Instant.now();
        System.out.println(instant);//本初子午线的时间，加8个小时为本地时间

        //添加时间的偏移量 加8个小时
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970年1月1日0时0分0秒（UTC）开始的秒数

        long milli = instant.toEpochMilli();
        System.out.println(milli); //1638502236164

        //ofEpochMilli()通过给定的毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(1638502236164L);
        System.out.println(instant1);
    }

    /**
     *DateTimeFormatter:格式化或解析日期 时间
     * 类似于：SimpleDateFormat
     */
    @Test
    public void test3(){
        //方式一：预定义的标准格式：如ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        // 格式化： 日期--》字符串
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(formatter.format(now));
        //解析： 字符串--》日期
        TemporalAccessor parse = formatter.parse("2021-12-03");
        System.out.println(parse);
        System.out.println("*********************************");

        //方式二：本地化相关格式
        //ofLocalizedDateTime（）
        DateTimeFormatter d1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        System.out.println(d1.format(now));
        System.out.println("*********************************");

        //方式三：自定义的格式  ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(pattern.format(now));

    }
}
