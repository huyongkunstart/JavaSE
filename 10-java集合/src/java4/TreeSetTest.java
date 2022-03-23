package java4;

import java1.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author hu
 * @create 2022-01-04 13:49
 */
public class TreeSetTest {
    @Test
    /*
    1.向TreeSet中添加的数据，要求是相同类的对象
    2.两种排序方式：自然排序和定制排序

    3.自然排序中，比较两个对象是否相同的标准为：compareTo（）返回0，不再是equals（）方法
    4.定制排序中，比较两个对象是否相同的标准为：compare（）返回0，不再是equals（）方法
     */
    public void test1(){
        Set set = new TreeSet();
        //失败
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("Tom",21));

        //举例一：按照从小到大的顺序排序
//          set.add(34);
//          set.add(334);
//          set.add(4);
//          set.add(-4);
//          set.add(24);
        //举例二
            set.add(new Person("hu",21));
            set.add(new Person("uuj",12));
            set.add(new Person("jihf",34));
            set.add(new Person("see",56));
            set.add(new Person("Tom",44));
            set.add(new Person("Tom",66));
            set.add(new Person("tom",66));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    //定制排序
    public void test2(){
        Comparator com = new Comparator(){
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        //定制排序
        TreeSet set = new TreeSet(com);
        set.add(new Person("nihao",21));
        set.add(new Person("hu",21));//添加不成功
        set.add(new Person("uuj",12));
        set.add(new Person("jihf",34));
        set.add(new Person("see",56));
        set.add(new Person("seee",56));//添加不成功
        set.add(new Person("Tom",44));
        set.add(new Person("Tom",66));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
