package com.hu.java4;

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
        //sql中的Date
        java.sql.Date date2 = new java.sql.Date(1638439436019L);
        System.out.println(date2); //2021-12-02

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一
        Date date3 = new Date(1638439436019L);
        java.sql.Date date4 = (java.sql.Date)date3;

        //情况二
        Date date6 = new Date(); //java.util.Date
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }
}
