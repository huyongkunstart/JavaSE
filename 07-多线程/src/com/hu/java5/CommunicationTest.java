package com.hu.java5;

/**
 * 线程通信的例子：使用两个线程打印1-100 线程1 线程2 交替打印
 * @author hu
 * @create 2021-11-03 11:01
 */

class Number implements Runnable{
    private  int number =1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {

                this.notify();

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() +":"+ number);
                    number++;
                    //将当前调用wait（）方法的线程阻塞
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number a = new Number();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
