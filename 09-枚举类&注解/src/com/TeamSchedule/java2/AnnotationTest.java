package com.TeamSchedule.java2;

import java.util.ArrayList;

/**
 * 注解的使用
 * JDK5.0新增
 *示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 * @Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 * @author hu
 * @create 2021-12-06 22:24
 */
public class AnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int a = 12;
    }
}
//jdk8新增的Target可修饰的地方 TYPE_PARAMETER
class Aaa<@MyAnnotation T>{
    //在抛异常的地方和泛型内 TYPE_USE
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
    }
}


//重复注解
//jdk1.8之前的方式：使用MyAnnotation数组
//@MyAnnotations({@MyAnnotation(value = "hi"),@MyAnnotation(value = "hello")})

//jdk1.8之后
@MyAnnotation(value = "hi")
@MyAnnotation(value = "hello")
/*
这样写不行
@MyAnnotation(value = "hi")
@MyAnnotation(value = "hello")
*/
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void walk(){

    }
}

interface Info{
    void show();
}

class Student extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }
    public void show(){

    }
}
