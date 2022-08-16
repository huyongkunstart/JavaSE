import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author huyongkun
 * @ClassName Test1
 * @create 2022-06-23 10:34
 * @Version 1.0
 * @description: TODO
 */
public class Test1 {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
//            Object next = iterator.next();
//            list.add(12);
//            System.out.println();
        }
        System.out.println(list);
    }

    @Test
    public void test2(){
        Object[] a = new Object[10];

        a[0] = 3.4;

    }
}
