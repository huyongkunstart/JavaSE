package com.TeamSchedule.java8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huyongkun
 * @ClassName index1
 * @create 2022-05-14 13:08
 * @Version 1.0
 * @description: 使用线程池来创建线程
 */
public class index1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new MyThread());//使用于Runnable

        service.submit(new MyThread1()); //适用于Callable

        service.shutdown();//关闭线程池
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class MyThread1 implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
        return sum;
    }
}