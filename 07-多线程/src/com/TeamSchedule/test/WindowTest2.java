package com.TeamSchedule.test;

/**
 * @author hu 创建三个窗口卖票，总票数为100张  使用实现接口的方式
 * @create 2021-10-28 16:33
 *
 * 解决线程安全问题
 *  方法一：同步代码块
 *  synchroized(同步监视器){
 *       //需要被同步的代码
 *  }
 * 说明：
 *  1.操作共享数据的代码，即为需要被同步的代码    -->不能包含多了，也不能包含少了
 *  2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 *  3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁
 *      要求：多个线程必须要共用同一把锁
 *  4.同步的方式，解决了线程的安全问题  --好处
 *    操作同步代码时，只能有一个线程参与，其他线程等待。相当于一个单线程的过程，效率低  --局限性
 *  说明：
 *  1.在实现runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
 *  2.在继承thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器  类名.class
 *
 */



class Window2 implements Runnable{
    private int ticket =100;
//    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (this) { //此时的this：唯一的window1的对象
                if (ticket > 0) {
                    /*try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println(this.getClass());
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w = new Window2();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t1.start();

        t3.start();
    }
}
