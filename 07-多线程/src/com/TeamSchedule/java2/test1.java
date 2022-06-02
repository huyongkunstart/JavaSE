package com.TeamSchedule.java2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shkstart
 * @create 2022-05-06 8:10
 * @description：
 */
public class test1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);
        thread1.setName("t1窗口");
        thread2.setName("t2窗口");
        thread3.setName("t3窗口");
        thread2.start();
        thread1.start();

        thread3.start();
    }
}


class Ticket implements Runnable{
    private static int tick  =100;
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
                lock.lock();
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出车票，tick号为:" + tick--);
                } else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}