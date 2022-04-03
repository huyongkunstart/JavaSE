package java5;

import org.junit.Test;

import java.util.*;

/**
 * 一.Map的实现类的结构
 * -----Map接口：双列数据，存储key-value对的数据  类似于高中的函数：y=f(x)
 *     -----HashMap:作为Map的主要实现类；线程不安全，效率高 ；存储null的key和value
 *           ------LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                      对于频繁的遍历操作，此类执行效率高于HashMap。
 *     -----TreeMap：保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序和定制排序。
 *                   底层使用红黑树。
 *     -----Hashtable：作为古老的实现类 线程安全，效率低
 *          -----Properties：常用来处理配置文件。key和value都是String类型。
 *
 *     HashMap的底层：数组+链表 jdk7及之前
 *                   数组+链表+红黑树（jdk8）
 *
 * 面试题：
 * 1.HashMap的底层实现原理？
 * 2.HashMap和Hashtable的异同？
 * 3.CurrentHashMap与Hashtable的异同？
 * @author hu
 * @create 2022-01-04 17:58
 */
public class MapTest {
    @Test
    public void test1(){
        Map map = new HashMap();
//        map = new Hashtable();
        map.put(null,null);

    }

// 1.常用方法  添加、删除、修改操作：
    /*
    Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
    void putAll(Map m):将m中的所有key-value对存放到当前map中  Object remove(Object key)：移除指定key的key-value对，并返回value
    void clear()：清空当前map中的所有数据
     */
    @Test
    public void tets2(){
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",123);
        //修改
        map.put("AA",87);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)
        map.remove("CC");
        System.out.println(map);

        //clear（）
        map.clear();
        System.out.println(map);

    }

    //2.元素查询的操作：
    // Object get(Object key)：获取指定key对应的value
    // boolean containsKey(Object key)：是否包含指定的key
    // boolean containsValue(Object value)：是否包含指定的value
    // int size()：返回map中key-value对的个数
    // boolean isEmpty()：判断当前map是否为空
    // boolean equals(Object obj)：判断当前map和参数对象obj是否相等
    @Test
    public void test3(){

    }

    //3.元视图操作的方法：
    // Set keySet()：返回所有key构成的Set集合
    // Collection values()：返回所有value构成的Collection集合
    // Set entrySet()：返回所有key-value对构成的Set集合
    //Map没有Iterator迭代器
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",123);
        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("==================");
        //遍历所有的value集：values()
        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println("==================");

        //遍历所有的key-value
        //方式一
        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            Object obj = iterator2.next();
            //enterSet集合中的元素都是Entry
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }


        //方式二
        Set keyset = map.keySet();
        Iterator iterator3 = keyset.iterator();
        while (iterator3.hasNext()){
            Object key = iterator3.next();
            Object value = map.get(key);
            System.out.println(key+"--->"+value);
        }



       /*

       //遍历所有的key-value
        Set set1 = hashMap.entrySet();

        //方法一：
        Iterator iterator = set1.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry next1 = (Map.Entry) next;
            System.out.println(next1.getKey()+"---->"+next1.getValue());
        }

        //方法二：
        for (Object o : set1) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey()+"---->"+entry.getValue());
        }

        //方法三：
        Set keySet = hashMap.keySet();
        for (Object o : keySet) {
            System.out.println(o+"---->"+hashMap.get(o));
        }*/



    }

}
