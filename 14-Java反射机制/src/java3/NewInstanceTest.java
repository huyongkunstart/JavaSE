package java3;

import java1.Person;
import org.junit.Test;

import java.util.Random;

/**
 * 4.通过反射创建对应的运行时类的对象
 * @author hu
 * @create 2022-01-28 15:23
 */
public class NewInstanceTest {
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
        /*
        * 一、newInstance()调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参构造器
        *
        * 要想此方法正常的创建运行时类的对象，要求：
        * 1.运行时类必须提供空参的构造器
        * 2.空参的构造器的访问权限得够。通常设置为Public
        *
        *
        * 二、在javabean中要求提供一个public的空参构造器。原因：
        * 1.便于通过反射，创建运行时类的对象
        * 2.便于子类继承此运行时类时，默认调用super（）时，保证父类有此构造器
        *
        * */
        Person p1 = clazz.newInstance();
        System.out.println(p1);
    }


    //体会反射的动态性例子
    @Test

    public void test2() throws Exception {
        int num = new Random().nextInt(3); //0,1,2
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "java1.Person";
                break;
        }
        Object obj = getInstance(classPath);
        System.out.println(obj);

    }

    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
