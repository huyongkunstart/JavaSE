package com.TeamSchedule.java2;

/**
 * 方式二：实现Runnable接口
 * 1) 创建一个实现Runnable接口的类
 * 2) 实现Runnable接口中的run抽象方法。
 * 3) 创建实现类的对象
 * 4) 将此对象作为参数传递给Thread类的构造器中，创建Thread类的对象。
 * 5) 调用Thread类的start方法：开启线程，调用Runnable子类接口的run方法
 * @author hu
 * @create 2021-10-28 16:09
 */

class MThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class index2 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.setName("线程一");
        t1.start();

        //再创建一个线程 实现100以内的偶数
        Thread t2 = new Thread(mThread);
        t2.setName("线程二");
        t2.start();
    }
}
