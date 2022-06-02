package com.hu2.java1;

import com.sun.org.apache.xerces.internal.util.XMLSymbols;

/**
 * @author shkstart
 * @create 2022-05-10 9:23
 * @description：  线程之间的通信 wait notify notifyAll 使用两个线程打印1-100 线程1 线程2 交替打印
 */
public class index4 {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}

class Window implements Runnable{
    private int a = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                if(a<=100){
                    System.out.println(Thread.currentThread().getName()+":"+a++);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}