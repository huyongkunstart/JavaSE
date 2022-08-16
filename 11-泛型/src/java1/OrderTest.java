package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1.自定义泛型类
 * @author hu
 * @create 2022-01-09 16:05
 */
public class OrderTest {
    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明的泛型，则认为此泛型类型为Object类型
        //要求：如果定义的类是带泛型的，建议实例化时要指明类的泛型
        Order<String> o = new Order<>("hu",12,"zhongguo");
        o.setOrderT("henan");
        System.out.println(o);
    }
    @Test
    public void test2(){
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型。
        SubOrder subOrder = new SubOrder();
        Integer orderT = subOrder.getOrderT();
    }
    @Test
    public void test3(){
        SubOrder1<Integer> s1 = new SubOrder1<>();
        Integer orderT = s1.getOrderT();
        System.out.println(orderT);

    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = {1, 2, 3, 4};
        //泛型方法的调用时，指明泛型参数的类型
        List<Integer> integers = order.copyFromArrayToList(arr);
        System.out.println(integers);

        order.test1(new Date(),12);

        //
        List<String>  list1 = null;
        ArrayList<String> list2 = null;
        list1 = list2;

    }





}
