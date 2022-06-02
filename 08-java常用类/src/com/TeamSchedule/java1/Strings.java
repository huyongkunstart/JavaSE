package com.TeamSchedule.java1;

import org.junit.Test;

/**
 * @author hu
 * 1.字符串相关的类：String
 * @create 2021-12-02 14:07
 * String的实例化方式
 * 方式一：通过字面量定义的方式
 * 方式二：通过new+构造器的方式
 *
 * 面试：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
 *  两个，一个是在堆空间new结构，另一个是char[]对应的常量池中的数据："abc"
 */
public class Strings {
    @Test
    public void test(){
        //通过字面量定义的方式:此时的s1和s2的数据JAVAEE生命在方法区中的字符串常量池中
        String s1 = "JAVAEE";
        String s2 = "JAVAEE";
//      通过new+构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间开辟空间以后对应的地址值
        String s3 = new String("javaee");
        String s4 = new String("javaee");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //false
        System.out.println(s3 == s4); //false

        System.out.println("----------------------------------------");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);
        System.out.println(p1.name.equals(p2.name)); //true
        System.out.println(p1.name == p2.name); //true
        System.out.println(p1.name == "Tom"); //true

        p1.name = "hu";
        System.out.println(p2.name);//Tom

    }

    /*
    结论：
    常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
    只要其中有一个是变量，结果就在堆中
    如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test2(){
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";
        String s4 = s1 + "world";
        String s5 = s1 + s2;
        String s6 = (s1+s2).intern();
        String s7 = "helloworld";
        System.out.println(s3==s4); //false
        System.out.println(s3==s5); //false
        System.out.println(s4==s5); //false
        System.out.println(s3==s6); //true
        System.out.println(s7==s6); //true
        System.out.println(s3==s7); //true


    }

}
