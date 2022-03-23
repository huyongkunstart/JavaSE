package java3;

import org.junit.Test;

/**
 * Collection接口 ；单列集合，用来存储一个一个的对象
 * ------List接口：存储有序的，可重复的数据
 *       -----ArrayList实现类：作为List接口的主要实现类，线程不安全，效率高；底层使用Object[]存储
 *       -----LinkedList实现类：对于频繁的插入，删除操作，使用此类比ArrayList效率高；底层使用双向链表存储
 *       -----Vector实现类：作为List接口的古老实现类 ，线程安全，效率低；底层使用Object[]存储
 *
 *面试题：ArrayList LinkedList Vector三者的异同
 * 同：三个类都实现了List接口，存储数据的特点相同：存储有序的，可重复的数据
 *
 *
 *
 *
 *
 *
 *
 * @author hu
 * @create 2022-01-03 17:07
 */
public class ListTest {
    //List接口常用的方法
    @Test
    public void  test1(){
        /* void add(int index, Object ele):在index位置插入ele元素
        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        Object get(int index):获取指定index位置的元素
        int indexOf(Object obj):返回obj在集合中首次出现的位置
        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        Object remove(int index):移除指定index位置的元素，并返回此元素
        Object set(int index, Object ele):设置指定index位置的元素为ele
        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex 位置的子集合*/


    }
}
