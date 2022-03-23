package com.hu.java7;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparable接口的使用举例：自然排序
 * 1.像String，包装类等实现了comparable接口，重写了compareTo（obj）方法，给出了比较两个对象
 * @author hu
 * @create 2021-12-03 18:32
 */
public class CompareTest {
    @Test
    public void test(){
        Goods[] goods = new Goods[4];
        goods[0] = new Goods(34,"lenovoMouse");
        goods[1] = new Goods(64,"dellMouse");
        goods[2] = new Goods(14,"xiaomiMouse");
        goods[3] = new Goods(84,"huaweiMouse");
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /**
     *
     * 定制排序 java.util.Comparator
     */
    @Test
    public void test2(){
       String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
       Arrays.sort(arr, new Comparator() {
           //按照字符串从大到小排列
           @Override
           public int compare(Object o1, Object o2) {
               if(o1 instanceof String && o2 instanceof String){
                   String s1= (String)o1;

                   String s2= (String)o2;
                   return -s1.compareTo(s2);
               }
               throw  new RuntimeException("输入的数据类型不一致");
           }

       });
    }
}
