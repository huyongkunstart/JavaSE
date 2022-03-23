package java1;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用 jdk1.5新增
 * 1.集合接口或集合类在jdk5.0时修改为带泛型的结构
 * 2.在实例化集合类时，可以指明具体的泛型类型
 * 3.指明完以后，在集合类或接口中凡是定义类或接口时，内部结构(比如：方法，构造器，属性等)使用到类的泛型的位置，
 * 都指定为实例化的泛型类型。
 * 比如：add(E e) ---> 实例化以后：add(Integer e)
 * 4.泛型的类型必须是类，不能是基本数据类型。需要基本类型的时候用包装类
 * 5.实例化没有使用泛型，默认是java.lang.Object类型
 *
 *
 *
 * @author hu
 * @create 2022-01-06 12:44
 */
public class GenericTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(23);
        list.add(100);
        list.add(98);
        list.add(66);
        //问题一：类型不安全
        list.add("Tom");

        for(Object score : list){
            //强转出现异常：java.lang.ClassCastException
            int stuScore = (int) score;
            System.out.println(stuScore);
        }

    }

    //在集合中使用泛型 以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(56);
        list.add(100);
        list.add(67);
//        list.add("Tom");
        //方式一
        /*for(Integer score : list){
            //强转出现异常：java.lang.ClassCastException
            int stuScore =score;
            System.out.println(stuScore);
        }*/
        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }
    }
    //在集合中使用泛型 以HashMap为例
    @Test
    public void test3(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("朱童",100);
        map.put("朱晓",100);
        map.put("朱方圆",98);
        map.put("朱蝴蝶",12);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
       /* Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key+"---->语文考了"+value+"分");
        }*/
        for(Map.Entry<String,Integer> entry : set){
            System.out.println(entry.getKey()+"------->语文考了"+entry.getValue()+"分");
        }

    }




}
