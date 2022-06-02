package com.TeamSchedule.java1;

/**
 * 测试Thread中的常用方法
 * 1.start()：启动当前线程；调用当前线程的run()
 * 2.run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread（）： 静态方法 返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield(): 释放当前cpu的执行，有可能释放之后又分配到此线程
 * 7.join(): 在线程a中调用线程b的join()方法，此时线程a就进入阻塞状态，直到线程b完全执行完以后线程a才结束阻塞状态
 * 8.stop(): 已过时，强制结束线程命令
 * 9.sleep(): 让当前线程“睡眠”指定毫秒，在指定的毫秒内，线程处于阻塞状态
 * 10. isAlive():判断当前线程是否存活
 *11.线程优先级设置
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5
 * getPriority() ：返回线程优先值
 * setPriority(int newPriority) ：改变线程的优先级
 * 线程创建时继承父线程的优先级
 * 低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用
 *
 * @author hu
 * @create 2021-10-22 16:15
 */

class MyThread1 extends Thread{
    MyThread1(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                /*try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(getName()+getPriority()+":"+i);
            }
//            if(i%20==0) yield();
        }
    }
}

public class index2 {
    public static void main(String[] args){
        MyThread1 m1=new MyThread1("线程一");
//        m1.setName("线程一");
        m1.start();

        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority()+":"+i);
            }
           /* if(i%20 ==0){
                try {
                    m1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }
//        System.out.println(m1.isAlive());
    }

}
