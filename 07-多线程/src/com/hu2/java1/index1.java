package com.hu2.java1;

/**
 * @author shkstart
 * @create 2022-04-10 16:48
 * @description：
 */
public class index1{
    public static void main(String[] args) {
        Thread a = new A();
        a.start();
        B b = new B();
        Thread t1 = new Thread(b);

    }

}

//创建线程的方式一 ：继承Thread类
class A extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                System.out.println(i);
            }
        }
    }
}

//创建线程的方式二：实现Runnable接口
class B implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 != 0){
                System.out.println(i);
            }
        }
    }
}
