package com.hu.java1;

/**
 * 多线程的创建 方式一：继承Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 *
 * @author hu
 * @create 2021-10-22 16:15
 */
//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
//   2.重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                System.out.println(i);
            }
        }
    }
}

public class index1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("hello");
    }
}

