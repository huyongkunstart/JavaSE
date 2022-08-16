package com.TeamSchedule.面试1;

import org.junit.Test;

/**
 * @author hu
 * @create 2021-12-02 17:46
 */
public class StringTest2 {
    @Test
    public void test1(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());// 4
        System.out.println(sb);// "null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常
        System.out.println(sb1);// 抛异常
    }

    @Test
    public void test2(){
        String a = "123";
        String b = "123";
        String c = new String("123");
        String d = new String("123");
        System.out.println(a.equals(b)); //true
        System.out.println(a==b);        //true
        System.out.println(c.equals(d)); //true
        System.out.println(c==d);        //false
        System.out.println(a.equals(c)); //true
        System.out.println(a==c);        //false

    }
}
