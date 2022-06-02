package com.TeamSchedule.java3;

import org.junit.Test;

/**
 * @author hu
 * @create 2021-12-02 17:03
 * String StringBuffer StringBuilder三者的异同
 * String:不可变的字符序列
 * StringBuffer：可变的字符序列：线程安全的，效率低
 * StringBuilder：可变的字符序列：线程不安全，效率高
 *      StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
 *      StringBuffer delete(int start,int end)：删除指定位置的内容
 *      StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
 *      StringBuffer insert(int offset, xxx)：在指定位置插入xxx
 *      StringBuffer reverse() ：把当前字符序列逆转
 *
 * 常用方法：
 *
 */
public class StringBufferBuilderTest {
    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1); //abc11
        s1.delete(2,4);
        System.out.println(s1); //ab1
        s1.replace(2,4,"hello");
        System.out.println(s1); //abhello
        s1.insert(0,"hu");
        System.out.println(s1); //huabhello
        s1.reverse();
        System.out.println(s1); //ollehbauh
    }
}
