package com.hu.java5;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化和解析
 * @author hu
 * @create 2021-12-02 23:12
 */
public class TestSimpleDateFormat {
    @Test
    public void test1() throws ParseException {
        //实例化:使用默认的构造器
        SimpleDateFormat d1 = new SimpleDateFormat();
        //格式化 日期---》字符串
        Date date = new Date();
        System.out.println(d1.format(date));

        //解析：格式化的逆过程，字符串---》日期
        //格式化的解析必须按他的格式，不然报错
        String str = "19-12-2 下午11:11";
        Date parse = d1.parse(str);
        System.out.println(parse);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //实例化：使用自己定义的构造器
        SimpleDateFormat d2 = new SimpleDateFormat("yyyy.MM.dd GGG hh:mm aaa");
        SimpleDateFormat d3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(d2.format(date));
        System.out.println(d3.format(date));
    }
}
