package com.hu.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：lock锁 JDK5.0新增
 * @author hu
 * @create 2021-11-03 10:12
 */

class Window5 implements Runnable{
    private int ticket = 100;
    //1.显实例化lock
    private  ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try {
                //2,调用锁定lock()方法
                lock.lock();

                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":售票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3.调用解锁方法
                lock.unlock();
            }
        }
    }
}

public class WindowTest5 {
    public static void main(String[] args) {
        Window5 a = new Window5();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        Thread t3 = new Thread(a);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
