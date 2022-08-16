package java7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collection:操作Collection，Map的工具类
 * @author hu
 * @create 2022-01-05 14:12
 */
public class CollectionsTest {
    //void copy(List dest,List src)：将src中的内容复制到dest中
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(234);
        list.add(454);
        list.add(111);
        list.add(-456);
//报错：java.lang.IndexOutOfBoundsException: Source does not fit in dest
//        List dest = new ArrayList();
//        Collections.copy(dest,list);

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(list);
        System.out.println(dest);

    }
}
