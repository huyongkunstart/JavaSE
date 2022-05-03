package com.hu.java1;

/**
 * @author shkstart
 * @create 2022-04-10 17:21
 * @description：
 *
 * 
 */
public class index3 {
    public static void main(String[] args) throws InterruptedException {
        MyThread111 a = new MyThread111();
        a.setName("t1");
        a.start();

        //等待5秒后把t1线程从睡眠中中断
        Thread.sleep(5*1000);
        //中断t1线程的睡眠，这种中断睡眠的方式使用了java的异常处理机制
        a.interrupt();

    }
}

class MyThread111 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"----->begin");
        //睡眠1年
        try {
            Thread.sleep(1*1000*60*60*24*365);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"----->end");


    }
}
