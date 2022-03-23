package java1;

import org.junit.Test;

import java.util.*;

/**
 * @author hu
 * @create 2022-01-03 10:47
 */
public class CollectionTest {
    @Test
    public void Test1(){
        Collection collection = new ArrayList();
        //1.add(Object e) 将元素e添加到集合collection
        collection.add("AA");
        collection.add("BB");
        collection.add(123);
        collection.add(new Date());

        //2.size();获取添加的元素的个数
        System.out.println(collection.size());

        //3.addAll() 将collection1中的元素添加到当前集合
        Collection collection1 = new ArrayList();
        collection1.add(456);
        collection1.add("CC");
        collection.addAll(collection1);
        System.out.println(collection.size());
        System.out.println(collection);

        //4.clear() 清空集合元素
        collection.clear();
        //5.isEmpty() 判断当前集合是否为空
        System.out.println(collection.isEmpty());

    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(456);
        /*Person p = new Person("hu", 34);
        coll.add(p);*/
        coll.add(new Person("hu",34));

        //1.contains(Object obj)判断当前集合中是否包含obj 调用的是obj所在类的equals
        boolean contains = coll.contains(123);
        System.out.println(contains); //True
        System.out.println(coll.contains(new String("Tom")));//true 重写了equals方法
        //System.out.println(coll.contains(p)); //true
        System.out.println(coll.contains(new Person("hu",34))); //false 重写Person类中的equals方法就可以变为true

        System.out.println("====================================");
        //2.containsAll(Collection coll1) 判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,456,new String("Tom")); //asList返回的是ArrayList
        boolean b = coll.containsAll(coll1);
        System.out.println(b);  //true

        System.out.println("====================================");
        //3.remove(Object obj)
        boolean remove = coll.remove(123);
        System.out.println(remove);
        System.out.println(coll);

        System.out.println("====================================");
        //4.removeAll(Collection coll1)求差集 从当前集合中移除coll1中的所有元素
        System.out.println(coll);
        boolean b1 = coll.removeAll(coll1);
        System.out.println(b1);
        System.out.println(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("hu",21));
        coll.add(new String("Tom"));
        coll.add(false);

        //1.retainAll(Collection coll1) 交集：获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123,456,789);
        boolean b = coll.retainAll(coll1);
        System.out.println(coll);

        //equals(Object obj)  集合是否相等
        System.out.println(coll.equals(coll1));

        //hashcode() 获取集合对象的哈希值
        System.out.println(coll.hashCode());

        //toArray()   集合转成对象数组
        Object[] objects = coll.toArray();
        for (Object i : objects){
            System.out.println(i);
        }
        System.out.println("==========================");
        //数组--->集合 调用Arrays类的静态方法asList()
        Collection list = Arrays.asList("AA","BB","CC");
        System.out.println(list);

        //iterator() 返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中

    }
}
