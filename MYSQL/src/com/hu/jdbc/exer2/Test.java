package com.hu.jdbc.exer2;

import java.lang.reflect.Field;

/**
 * @author huyongkun
 * @ClassName Test
 * @create 2022-06-30 15:02
 * @Version 1.0
 * @description: TODO
 */
public class Test {
    //修改这个常量字段的值
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("com.hu.jdbc.exer2.Person");

        //创建对象
        Object obj = clazz.newInstance();

        Field f = clazz.getDeclaredField("name");
        f.setAccessible(true);

        //修改f对象name字段的权限
        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);

        modifiers.set(f,1);

        f.set(obj,"鱼羊鲜");
        System.out.println(f.get(obj));


    }
}
class Person{
    private final String name = "小大尖";

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
