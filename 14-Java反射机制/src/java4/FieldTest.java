package java4;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的完整结构（了解）
 *
 * 使用反射可以取得：
 *   1.实现的全部接口
 *   2.所继承的父类
 *   3.全部的构造器
 *   4.全部的方法
 *   5.全部的Field
 *   6. Annotation相关
 *   7.泛型相关
 *   8.类所在的包
 *   具体看笔记（了解）
 *
 * @author hu
 * @create 2022-01-29 15:27
 */
public class FieldTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //获取属性结构:获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }
        System.out.println("***************************");

        //getDeclaredFields():获取当前运行时类中声明的所有属性。(不包含父类中声明的属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        }

    }

    //权限修饰符  数据类型   变量名
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f :  declaredFields){
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers)+"\t");
            //2.数据类型
            Class type = f.getType();
            System.out.print(type + "\t");
            //3.变量名
            String name = f.getName();
            System.out.println(name);


        }
    }

}
