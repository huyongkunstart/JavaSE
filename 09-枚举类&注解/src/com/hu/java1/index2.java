package com.hu.java1;

import org.junit.Test;

/**
 * @author hu
 * @create 2021-12-05 0:07
 */
public class index2 {
    @Test
    public void test(){
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println("************");
        //values()方法
        Season1[] values = Season1.values();
        for (Season1 i : values){
            System.out.println(i);
        }
        System.out.println("************");
        //valuesOf()
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }


}

//使用enum关键字创建枚举类
//枚举类默认继承java.long.Enum类
//方式三：Enum类常用方法
//    values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
//    valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符
//     串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
//    toString()：返回当前枚举类对象常量的名称
enum Season1{
    //提供当前枚举类对象
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");

    //1.声明对象的属性：private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器
    private  Season1(String seasonName,String seasonDesc){
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

}