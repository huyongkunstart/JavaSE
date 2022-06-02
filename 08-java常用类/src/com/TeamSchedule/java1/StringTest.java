package com.TeamSchedule.java1;

import org.junit.Test;

/**
 * string声明为final的，不可被继承
 * string实现了Serializable接口：表示字符串是支持序列化的
 *       实现了Comparable接口：表示string可以比较大小
 * string 代表不可变的字符序列：简称不可变性
 *  体现:1.当对字符串重新赋值时候，需要重新指定内存区域赋值，不能使用原有的value进行赋值
 *      2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
 *      3.当调用string的replace（）方法修改指定字符或字符串时，不能使用原有的value进行赋值
 * 通过字面量的方法（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
 * 字符串常量池中是不会存储相同内容的字符串
 * @author hu
 * @create  2021-11-10 23:18
 */
public class  StringTest {
    @Test
    public void test1(){
        //通过字面量的定义方式
        String s1 = "abc";
        String s2 = "abc";
        s1 = "helloo";
        System.out.println(s1);
        System.out.println("==================================");

        String s3 = "abc";
        s3+="def";
        System.out.println(s3);

        System.out.println("==================================");

        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s5);

        System.out.println("==================================");
    }
}
