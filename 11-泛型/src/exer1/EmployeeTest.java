package exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author huyongkun
 * @ClassName EmployeeTest
 * @create 2022-05-17 12:52
 * @Version 1.0
 * @description: TODO
 */
public class EmployeeTest {
    @Test
    public void test1(){
        Employee e1 = new Employee("guoshuhap", 78, new MyDate(2000, 6, 23));
        Employee e2 = new Employee("sdfsdf", 23, new MyDate(1845, 4, 7));
        Employee e3 = new Employee("asdf", 45, new MyDate(2022, 12, 12));
        Employee e4 = new Employee("afadg", 10, new MyDate(1845, 4, 7));
        Employee e5 = new Employee("afafdg", 23, new MyDate(1780, 1, 20));
        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //定制排序
    @Test
    public void test2(){
        Employee e1 = new Employee("guoshuhap", 78, new MyDate(2000, 6, 23));
        Employee e2 = new Employee("sdfsdf", 23, new MyDate(1845, 4, 7));
        Employee e3 = new Employee("asdf", 45, new MyDate(2022, 12, 12));
        Employee e4 = new Employee("afadg", 10, new MyDate(1845, 4, 7));
        Employee e5 = new Employee("afafdg", 23, new MyDate(1780, 1, 20));

        Comparator<Employee> com = new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
//                //比较年
//                int a = o1.getBirthday().getYear()-o2.getBirthday().getYear();
//                if(a!=0){
//                    return a;
//                }
//                //比较月
//                int b = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
//                if(b != 0){
//                    return b;
//                }
//                //比较日
//                return o1.getBirthday().getDay()-o2.getBirthday().getDay();
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        };
        TreeSet<Employee> employees = new TreeSet<Employee>(com);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
