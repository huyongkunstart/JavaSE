package com.TeamSchedule.test;

/**
 * 创建三个窗口卖票，总票数为100张  使用继承的方式
 * @author hu
 * @create 2021-10-22 21:16
 * 使用同步方法解决继承thread类的方式的线程的安全问题
 *
 *
 */

class Window4 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    private static synchronized void show(){ //此处需要用静态方法 此时同步监视器为 Window.class
        if (ticket > 0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket--);
        }
    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window a1 = new Window();
        Window a2 = new Window();
        Window a3 = new Window();
        a1.setName("窗口一");
        a2.setName("窗口二");
        a3.setName("窗口三");
        a1.start();
        a2.start();
        a3.start();
    }
}
