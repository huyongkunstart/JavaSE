package exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
 *  * TreeSet 需使用泛型来定义）
 *  * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 *  * 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 *  * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 * @author hu
 * @create 2022-01-04 15:14
 */
public class EmployeeTest {
    //按姓名自然排序
    @Test
    public void test1(){
        Employee e1 = new Employee("zhangsan",21,new MyDate(1743,5,29));
        Employee e2 = new Employee("liudehua",44,new MyDate(1956,12,25));
        Employee e3 = new Employee("zhoujie",45,new MyDate(1876,11,15));
        Employee e4 = new Employee("guoshuhao",23,new MyDate(1901,9,7));
        Employee e5 = new Employee("liujin",23,new MyDate(2000,9,23));

        TreeSet set = new TreeSet();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    //按生日日期的先后排序
    @Test
    public void test2(){
        Employee e1 = new Employee("zhangsan",21,new MyDate(1743,5,29));
        Employee e2 = new Employee("liudehua",44,new MyDate(1956,12,25));
        Employee e3 = new Employee("zhoujie",45,new MyDate(1876,11,15));
        Employee e4 = new Employee("guoshuhao",23,new MyDate(1901,9,7));
        Employee e5 = new Employee("liujin",23,new MyDate(2000,9,23));
        //按生日日期的先后排序
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    int minusYear = b1.getYear() - b2.getYear();
                    if (minusYear != 0) {
                        return minusYear;
                    }

                    int minusMonth = b1.getMonth() - b2.getMonth();
                    if (minusMonth != 0) {
                        return minusMonth;
                    }

                    return b1.getDay() - b2.getDay();
                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        };


        TreeSet set = new TreeSet(com);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }



}
