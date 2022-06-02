package com.TeamSchedule.zifuchuan;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2022-05-11 12:34
 * @description： 字符串常用方法
 */
public class exer1 {

    //常用方法1
    @Test
    public void test1(){
        String a = "I am a man";
        System.out.println(a); //重写了toString方法,没有重写equals方法
        System.out.println("length:"+a.length());
        System.out.println("charAt:"+ a.charAt(2));
        System.out.println("isEmpty:"+a.isEmpty());
        System.out.println("toLowerCase:"+a.toLowerCase());
        System.out.println("toUppercase:"+a.toUpperCase());
        System.out.println("trim:"+a.trim());
        System.out.println("equals:"+a.equals("I am a man"));
        System.out.println("equalsIgnoreCase:"+a.equalsIgnoreCase("i am a man"));
        System.out.println("concat:"+a.concat(", I am a Student"));
        System.out.println("compareTo:"+a.compareTo("I am c"));
        System.out.println("substring:"+a.substring(5));
        System.out.println("sunstring:"+a.substring(7,10));
    }
    //常用方法2
    @Test
    public void test2(){
        String a = "The class String includes methods for examining individual";
        System.out.println("endsWith:"+a.endsWith(" individual"));
        System.out.println("startsWith:"+a.startsWith("The c"));
        System.out.println("startsWith:"+a.startsWith(" includes",16));
        System.out.println("contains:"+a.contains(" i"));
        System.out.println("indexOf:"+a.indexOf("a"));
        System.out.println("indexOf:"+a.indexOf("a",10));
        System.out.println("lastIndexOf:"+ a.lastIndexOf("i"));
        System.out.println("lastIndexOf:"+a.lastIndexOf("a",10));
    }
    //常用方法3
    @Test
    public void test3(){
        String a = "extends annotation.Annotation";
        System.out.println("replace:"+a.replace('e','v'));
        System.out.println("replace:"+a.replace("a","-aaa-"));
        //replaceAll()
        //replaceFirst
        //matches
        //split

    }


    //String与字符数组、字节数组的转换
    @Test
    public void test4(){
        //字符数组 ->String
        char[] a = {'a','b','s','t','r','a','c','t'};
        String b = new String(a,2,3);
        System.out.println(b); //str

        //String -> 字符数组
        String c = "implements";
        char[] d = c.toCharArray();
        for (char c1 : d) {
            System.out.print(c1+" "); //i m p l e m e n t s
        }
    }
    @Test
    public void test5(){
        //字节数组 ->String  解码
        byte[] a = {97,98,99,67};
        String b = new String(a);
        System.out.println(b); //abcC

        //String -> 字节数组  编码
        String c = "abc123中国";
        byte[] d = c.getBytes();
        System.out.println(Arrays.toString(d));
    }


}
