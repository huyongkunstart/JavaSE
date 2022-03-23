package exer2;

import org.junit.Test;
import java.util.HashSet;

/**
 * 经典，一定要理解
 * @author hu
 * @create 2022-01-04 16:13
 */
public class Test2 {
    @Test
    public void test1(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1); //没有删除掉，hash值变了
        System.out.println(set);
        set.add(new Person(1001,"CC"));//能加进去
        System.out.println(set);
        set.add(new Person(1001,"AA"));//能加进去，hash值一样，equals不一样
        System.out.println(set);
    }
}
