package com.hu2.java1;

import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author shkstart
 * @create 2022-05-10 9:22
 * @description： 线程创建的第三种方式 ，实现Callable接口
 */
public class index3 {
    public static void main(String[] args) {
        BBB bbb = new BBB();
//        BBB bbb1 = new BBB();
        FutureTask futureTask = new FutureTask(bbb);
        FutureTask futureTask2 = new FutureTask(bbb);
        Thread thread = new Thread(futureTask);
        Thread thread2 = new Thread(futureTask2);
        thread.start();
        thread2.start();
    }
}

class BBB implements Callable{
    @Override
    public Object call() throws Exception {
        synchronized (this){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
        return null;
    }
}