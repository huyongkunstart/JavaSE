package java1;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**反射机制的理解
 * @author hu
 * @create 2022-01-27 16:18
 */
public class ReflectionTest {
    //1.反射之前对于Person类的操作
    @Test
    public void test1(){
        //创建Person对象
        Person tom = new Person("Tom", 12);

        //2.通过对象，调用其内部属性和方法
        tom.age = 10;
        System.out.println(tom.toString());

        tom.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构
        //比如: name 、 showNation() 以及私有的构造器
    }

    //反射之后，对于Person的操作
    @Test
    public void test2() throws Exception{
        Class personClass = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 12);
        Person tom = (Person) obj;
        System.out.println(tom.toString());

        //空参构造器
        Constructor constructor2 = personClass.getConstructor();
        Object o = constructor2.newInstance();
        Person o1 = (Person) o;
        System.out.println(o1);

        //2.通过反射，调用对象指定的属性，方法
        //调用属性
        Field age1 = personClass.getField("age");
//        Field age = personClass.getDeclaredField("age");
        age1.set(tom,10);
        System.out.println(tom.toString());
        int o2 = (int) age1.get(tom);
        System.out.println(o2);


        //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(tom);

        System.out.println("-----------------------------------------------");

        //通过反射，可以调用Person类的私有结构的 。比如：私有的构造器，方法，属性
        //调用私有的构造器
        Constructor constructor1 = personClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person hu = (Person) constructor1.newInstance("hu");
        System.out.println(hu);

        //调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(hu,"HanMeimei");
        System.out.println(hu);

        //调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //调用方法
        String nation = (String) showNation.invoke(hu,"中国");
        System.out.println(nation);
    }

 /*   总结：
       疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
            建议：直接new的方式
           什么时候会使用：反射的方式。  反射的特征：动态性
       疑问2：反射机制与面向对象中的封装性是不是矛盾？如何看带着两个技术？
              不矛盾
*/



 /*二. 关于对java.long.Class类的理解
  1.类的加载过程：
    程序经过javac.exe命令后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
    此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类就作为Class的一个实例
  2.换句话说，Class的实例就对应着一个运行时类。
  3.加载到内存中的运行时类，会缓存一定的时间。在此时间内，我们可以通过不同的方式来获取此运行时类
 */
    //获取Class的实例的方法
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一: 调用运行时类的属性： .class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二:通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("java1.Person");
        System.out.println(clazz3);


        //方式四（了解）：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("java1.Person");
        System.out.println(clazz4.getSuperclass()); //Object

    }

    //4.Class实例可以是哪些结构？
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
// 只要数组元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }





}
