package com.hu.java5;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * calendar日历抽象类
 * @author hu
 * @create 2021-12-03 9:20
 */
public class CalendarTest {
    @Test

    public void test1(){
        //1.实例化
        //方式一：创建其子类(GregorianCalendar)的对象
        //方式二：调用其静态方法GetInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //2.常用方法
        //get()
        //这一月的第几天
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);//
        //这一年的第几天
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //更改Calendar的属性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        int i1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i1);

        //add()
        //属性加
        calendar.add(Calendar.DAY_OF_MONTH,3);
        int i2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i2);

        //getTime(): 日历类--》Date
        Date time = calendar.getTime();
        System.out.println(time);

        //setTime:Date-->日历类
        Date date = new Date();
        calendar.setTime(date);
        int i3 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i3);

    }
}
