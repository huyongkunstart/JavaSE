package java4;

import java1.Person;
import org.junit.Test;

import java.util.*;

/**
 *
 * 1.Set接口的框架
 * Collection接口
 *    ----set接口 存储无序，不可重复的数据
 *      ----HashSet:作为Set接口的主要实现类：线程不安全；可以存储null值
 *         ----LinkedHashSet：作为HashSet的子类：遍历其内部数据时，可以按照添加的顺序遍历；对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 *      ----TreeSet: 可以按照添加对象的指定属性，进行排序
 *
 *  1.set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法
 *
 * @author hu
 * @create 2022-01-03 22:57
 *
 */
public class SetTest {
    /*
    * 一.set:存储无序，不可重复的数据 ：以HashSet为例
        1.无序性:不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，
                            而是根据数据的哈希值决定的
        2.不可重复性：保证添加的元素按照equals（）判断时，不能返回true。即相同的元素只能添加一个
      二、添加元素的过程：以HashSet为例

    */

    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",21));
        set.add(new Person("Tom",21));
        set.add(129);
        System.out.println();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test11(){
        HashSet set = new HashSet();
        Person p1 = new Person("AA",1001);
        Person p2 = new Person("BB",1002);
        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        set.remove(p1);
        System.out.println(set);
        set.add(new Person("CC",1001));
        System.out.println(set);
        set.add(new Person("AA",1001));
        System.out.println(set);
    }

    @Test
    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
    //优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",21));
        set.add(new Person("Tom",21));
        set.add(129);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //练习：在List内去除重复数字值，要求尽量简单
    @Test
    public void test3(){
        List list = Arrays.asList(23, 435, 56, 23, 56, 1, 1, 0, 0, 0);
        System.out.println(list);
        HashSet hashSet = new HashSet(list);
        ArrayList list2 = new ArrayList(hashSet);
        System.out.println(list2);
    }



}
