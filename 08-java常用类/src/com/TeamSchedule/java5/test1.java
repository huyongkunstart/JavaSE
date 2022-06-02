package com.TeamSchedule.java5;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hu
 * @create 2021-12-02 23:24
 */
public class test1 {
    //练习一：字符串"2020-09-08"转化为java.sql.Date
    @Test
    public void test1() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat a1 = new SimpleDateFormat("yyyy-MM-dd");

        Date date = a1.parse(birth);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
    }

    //练习二：三天打鱼两天晒网  1990-01-01开始打鱼，问xxxx-xx-xx打鱼？晒网？
    //总天数 % 5 == 1.2.3;打鱼
    //总天数 % 5 == 4,0;晒网
    @Test
    //方式一：(date2.getTime()-date1.getTime()) / (1000*60*60*24)+1
    //方式二：1990-01-01 --》2019-12-31 + 2020-01-01 --》2020-09-08
    public void test2() {

    }
}
