package java1;

import org.omg.CORBA.Object;

/**
 * @author hu
 * @create 2022-01-09 16:17
 */
public class SubOrder1<T> extends Order<T>{//SubOrder1<T>任然是一个泛型类
//    private T[] arr = new T[10];
    private T[] arr = (T[]) new Object[10];
}
