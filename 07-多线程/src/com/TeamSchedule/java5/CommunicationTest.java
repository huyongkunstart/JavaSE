package com.TeamSchedule.java5;

/**
 * 线程通信的例子：使用两个线程打印1-100 线程1 线程2 交替打印
 * @author hu
 * @create 2021-11-03 11:01
 *
 *1.wait() //将当前调用wait（）方法的线程阻塞
 *2.notify() //一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，唤醒优先级高的\
 *3.notifyAll() //一旦执行此方法，就会唤醒所有被wait的线程
 */

class Number implements Runnable{
    private  int number =1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                //一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，唤醒优先级高的
                this.notify();
                //一旦执行此方法，就会唤醒所有被wait的线程
//                notifyAll();

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
