package com.hu.java2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hu
 * @create 2021-12-02 15:55
 */
public class StringTest1 {
    //字符串  基本数据类型、包装类 调用包装类的静态方法：parseXxx(str)
    @Test
    public void test1(){
        String s1 = "123";
        int num = Integer.parseInt(s1);
    }
    //基本数据类型、包装类  字符串 调用string重载的valueOf（）方法或者+
    @Test
    public void test2(){
       int num = 123;
       String s2 = String.valueOf(num);
       String s3 = num+"";
    }

    //String与字符数组转换
    /*
    字符数组  字符串
        String 类的构造器：String(char[]) 和 String(char[]，int offset，int
        length) 分别用字符数组中的全部字符和部分字符创建字符串对象。

    字符串  字符数组
        public char[] toCharArray()：将字符串中的全部字符存放在一个字符数组
        中的方法。
        public void getChars(int srcBegin, int srcEnd, char[] dst,
        int dstBegin)：提供了将指定索引范围内的字符串存放到数组中的方法

    字节数组  字符串
        String(byte[])：通过使用平台的默认字符集解码指定的 byte 数组，构
        造一个新的 String。 String(byte[]，int offset，int length) ：用指定的字节数组的一部分，
        即从数组起始位置offset开始取length个字节构造一个字符串对象。

    字符串  字节数组
        public byte[] getBytes() ：使用平台的默认字符集将此 String 编码为
        byte 序列，并将结果存储到一个新的 byte 数组中。
        public byte[] getBytes(String charsetName) ：使用指定的字符集将 此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。
     */
    @Test
    public void test3(){
        //String ----> char[];  调用string的tocharArray（）
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (char i : charArray){
            System.out.println(i);
        }
        //char[]---->String;  调用string的构造器
        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
        //编码   string -----> byte[]之间转换：调用string的getByte()
        String str3 = "abc123";
        byte[] bytes = str3.getBytes();
        System.out.println(Arrays.toString(bytes));
        //解码   byte[] ---> string 调用string的构造器
        String str4 = new String(bytes);
        System.out.println(str4);


    }
}
