package com.TeamSchedule.java4;

import org.junit.Test;

import java.util.Date;

/**
 * 2.JDK 8之前的日期时间API
 * @author hu
 * @create 2021-12-02 17:57
 */
public class DateTimeTest {
    //java.util.Date
        //java.sql.Date
    /*
    方法的使用
    toString() 显示当前的年 月 日 时 分 秒
    getTime() 获取当前Date对象对应的毫秒数。（时间戳）
     */
    @Test
    public void test1(){
        //构造器一：Date():创建一个对应当前时间的Date对象
        Date date = new Date();
        System.out.println(date.toString());//Thu Dec 02 18:13:26 CST 2021
        System.out.println(date.getTime()); //1638440006968
        //构造器二：
        Date date1 = new Date(1638439436019L);
        System.out.println(date1.toString());
        //构造器三：不用了 详情看源码构造器
        System.out.println("---------------------------------");
        Date date5 = new Date(100, 9, 10);
        System.out.println(date5.toString());
        //sql中的Date
        java.sql.Date date2 = new java.sql.Date(1638439436019L);
        System.out.println(date2); //2021-12-02

        //如何将java.util.Date对象转换为java.sql.Date对象
        //传入getTime的值
        //情况一
        Date date3 = new Date(1638439436019L);
        java.sql.Date date4 = new java.sql.Date(date3.getTime());

        //情况二
        Date date6 = new Date(); //java.util.Date\
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        //下面这种情况跟情况一相比会报错，因为java.sql.date extends java.util.Date
        //java.lang.ClassCastException: java.util.Date cannot be cast to java.sql.Date
        //java.sql.Date date8 = (java.sql.Date) date6;


    }
}
