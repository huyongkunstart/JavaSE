package java4;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author hu
 * @create 2022-01-29 16:32
 */
public class OtherTest {
    //获取构造器结构

    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor [] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors()：获取当前运行时类中声明的所有构造器
        Constructor [] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }


    //获取运行时类的父类
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        //获取运行时类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
        //获取运行时类的带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    @Test
    //获取运行时类的带泛型的父类的泛型
    public void test4(){
        Class<Person> clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;

        //获取泛型类型
        Type[] actualTypeArguments = genericSuperclass1.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }


    /*
    * 获取运行时类实现的接口
    * */
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;

        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }
        System.out.println();

        //获取运行时类的父类实现的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
    }

    /*
    * 获取运行时类所在的包
    * */
    public void test6() {
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /*
    * 获取运行时类声明的注解
    * */
    public void test7() {
        Class<Person> clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }


}
