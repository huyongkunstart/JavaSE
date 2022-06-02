package com.TeamSchedule.java4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shkstart
 * @create 2022-05-06 16:57
 * @description： lock锁 JDK5.0新增
 * ReentrantLock 类实现了 Lock ，它拥有与 synchronized 相同的并发性
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();

    }
}


class Window implements Runnable{
    private static int tick = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                //2.调用锁定方法lock()
                lock.lock();

                if(tick>0){


                    System.out.println(Thread.currentThread().getName()+ "售票，票号为:"+tick--);
                }else {
                    break;
                }
            }finally {
                //释放锁
                lock.unlock();
            }

        }
    }
}
