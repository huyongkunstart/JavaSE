package java5;

import java4.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性，方法，构造器
 * @author hu
 * @create 2022-02-01 16:10
 */
public class Reflection {

    /*
    *获取运行时类的属性
    */
    @Test
    public void testFiled() throws Exception{
        Class<Person> clazz = Person.class;
        //创建运行时类对象
        Person p = clazz.newInstance();
        //获取指定的属性 （public权限的属性）
        //通常不使用此方法
        Field id = clazz.getField("id");
        //设置当前属性的值
        //set()：参数一：指明设置哪个对象的属性 参数2：将次属性值设置为多少
        id.set(p,1001);
        //获取当前属性的值
        //参数一：获取哪个对象的当前属性值
        int Pid = (int) id.get(p);
        System.out.println(Pid);
    }

    //获取运行时类指明的变量名的属性 （规范操作）
    @Test
    public void testField1() throws Exception{
        Class<Person> clazz = Person.class;

        Person p = clazz.newInstance();

        //getDeclaredField(String fieldName):获取运行时类中指明变量名的属性
        Field name = clazz.getDeclaredField("name");

        //保证当前属性是可访问的
        name.setAccessible(true);

        name.set(p,"Tom");
        String s = (String) name.get(p);
        System.out.println(s);

    }


    //获取运行时类指定的方法
    @Test
    public void testMethod() throws Exception{
        Class<Person> clazz = Person.class;
        //创建运行时类的对象
        Person p = clazz.newInstance();

        //获取指定的某个方法
        //getDeclaredMethod（）参数:1：指明获取的方法的名称
        // 参数2：指明获取的方法的形参列表

        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);

        //invoke() : 参数1：方法的调用者 参数2：给方法形参赋值的实参
        //invoke()的返回值即为对应类中调用的方法的返回值
        Object returnValue = show.invoke(p, "中国");
        System.out.println(returnValue);


        System.out.println("****************调用静态方法*******************");
        //调用静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object invoke = showDesc.invoke(Person.class);
        System.out.println(invoke); //null
    }

    //如何调用运行时类中指定的构造器

    @Test
    public void testConstruct() throws Exception{
        Class<Person> clazz = Person.class;
        //获取指定的构造器
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);

        //保证此构造器是可访问的
        constructor.setAccessible(true);

        //调用此构造器创建运行时类的对象
        Person tom = constructor.newInstance("Tom");
        System.out.println(tom.toString());

    }





}
