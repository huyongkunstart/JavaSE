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

        TreeSet<Employee> set = new TreeSet<Employee>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
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
        Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                    MyDate b1 = o1.getBirthday();
                    MyDate b2 = o2.getBirthday();
                    return b1.compareTo(b2);
            }
        };


        TreeSet<Employee> set = new TreeSet(com);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
        }

    }



}
