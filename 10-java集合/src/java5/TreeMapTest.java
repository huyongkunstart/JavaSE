package java5;

import org.junit.Test;

import java.util.*;

/**
 * @author hu
 * @create 2022-01-05 12:23
 */
public class TreeMapTest {
    //向TreeMap中添加key-value，要求key必须是由同一类创建的对象
    //因为要按照key进行排序：自然排序，定制排序
    @Test
    public void tets1(){
        TreeMap map = new TreeMap();
        Person p1 = new Person("hu",21);
        Person p2 = new Person("fre",12);
        Person p3 = new Person("sef",56);
        Person p4 = new Person("sef",10);
        map.put(p1,98);
        map.put(p2,78);
        map.put(p3,100);
        map.put(p4,60);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            //enterSet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }

    }
    //定制排序
    @Test
    public void test2(){
        Comparator com = new Comparator() {
            @Override
            //按照年龄从小到大排序
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeMap map = new TreeMap(com);
        Person p1 = new Person("hu",21);
        Person p2 = new Person("fre",12);
        Person p3 = new Person("sef",56);
        Person p4 = new Person("sef",10);
        map.put(p1,98);
        map.put(p2,78);
        map.put(p3,100);
        map.put(p4,60);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            //enterSet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
    }
}
