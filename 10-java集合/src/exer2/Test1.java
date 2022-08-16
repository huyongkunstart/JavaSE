package exer2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 在List内去除重复数字值，要求尽量简单
 * @author hu
 * @create 2022-01-04 16:08
 */
public class Test1 {
    public static List duplicateList(List list) {
        HashSet set = new HashSet(list);
//        set.addAll(list);
        return new ArrayList(set);
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

}
