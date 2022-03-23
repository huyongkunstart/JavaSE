package com.hu.java7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 新增线程创建方式:使用线程池
 * @author hu
 * @create 2021-11-03 15:06
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //设置线程池的属性
        System.out.println(service.getClass());
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
        service1.setCorePoolSize(15);

        //2.执行指定的线程操作，需要提供实现Runable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合适用于Runable
        service.execute(new NumberThread1());//适合适用于Runable
//        service.submit(Callable callable);//适合使用于Callable
        //3.关闭连接池
        service.shutdown();
    }
}
