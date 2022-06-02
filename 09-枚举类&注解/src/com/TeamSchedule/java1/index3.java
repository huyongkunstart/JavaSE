package com.TeamSchedule.java1;

import org.junit.Test;

/**
 * 使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口，在enum中实现实现抽象方法
 * 情况二：让枚举类的对象分别实现接口中的抽象方法
 * @author hu
 * @create 2021-12-05 0:25
 */
public class index3 {
    @Test
    public void test(){
        Season2 winter = Season2.WINTER;
        winter.show();
    }
}
interface Info{
    public abstract void show();
}

enum Season2 implements Info{
    //提供当前枚举类对象
    SPRING("春天","春暖花开"){
        @Override
        public void show(){
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show(){
            System.out.println("夏天在哪里");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show(){
            System.out.println("秋天在哪里");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show(){
            System.out.println("冬天在哪里");
        }
    };

    //1.声明对象的属性：private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器
    private  Season2(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }


    //其他述求：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}