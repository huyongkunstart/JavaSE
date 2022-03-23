package exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hu
 * @create 2022-01-03 22:40
 */
public class exer1 {
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list) {
        list.remove(2); //[1,2]
//        list.remove(new Integer(2)); //[1,3]
    }
}
