package com.hu.test;
/**
 * @author hu 创建三个窗口卖票，总票数为100张  使用实现接口的方式
 * @create 2021-10-28 16:33
 *
 * 解决线程安全问题
 * 方法二：同步方法
 * 1.使用同步方法解决实现runnable接口的线程安全问题
 *   如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步
 * 2.使用同步方法解决继承thread类的方式的线程的安全问题
 *   1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
 *   2.非静态的同步方法，同步监视器是：this
 *     静态的同步方法，同步监视器是：当前类本身
 */




class Window3 implements Runnable{
    private int ticket =100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    private synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket--);
        }
    }


}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
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
