package java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hu
 * @create 2022-01-09 22:41
 */
public class GenericTest {
    //1.泛型在继承方面的体现
    //类A是类B的父类，G<A>和G<B>二者不具备子父类关系，二者是并列关系
    @Test
    public void test1(){
        List<Object> list1 = null;
        List<String> list2 = new ArrayList<>();
//        编译不通过
//        list1 = list2;

        //反证法
    }
    //类A是类B的父类，A<G>和B<G> 二者具备子父类关系
    public void test2(){
        List<String>  list1 = null;
        ArrayList<String> list2 = null;
        list1 = list2;
    }



    //2.通配符的使用：？
    //类A是类B的父类，G<A>和 G<B> 是没有关系的，二者共同的父类是：G<?>
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        print(list1);
        print(list2);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //list添加数据(写入) ： 对于List<?>就不能向其内部添加数据,除了null之外
//        list.add("DD"); 不能添加
        list.add(null);
        //获取数据:允许读取数据，读取的数据类型是Object类型
        Object o = list.get(0);
        System.out.println(o);

    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }






    //3.有限制条件的通配符的使用
    // ? extends A
        //G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类
    // ? super A
        //G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类
    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;  extends相当于<=

//        list2 = list3;  super相当于>=
        list2 = list4;
        list2 = list5;

        //读取数据 可以读取数据
        list1 = list3;
        Person person = list1.get(0);

        list2 = list4;
        Object object = list2.get(0);


        //写数据
        //编译不通过
//        list1.add(new Student());
        //编译通过
        boolean add = list2.add(new Person());
        boolean add1 = list2.add(new Student());


    }



}
