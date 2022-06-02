package com.TeamSchedule;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author shkstart
 * @create 2022-05-07 16:37
 * @description： 新增的创建线程方式 实现Callable接口
 */
public class exer3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        Thread thread = new Thread(futureTask);
        thread.setName("分线程");
        thread.start();
        Object o = futureTask.get();
        System.out.println((int)o);
    }
}


class MyThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                sum += i;
                System.out.println(Thread.currentThread().getName()+"----->"+i);
            }
        }

        return sum;
    }
}
