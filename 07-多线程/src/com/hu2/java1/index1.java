package com.hu2.java1;

/**
 * @author shkstart
 * @create 2022-04-10 16:48
 * @description：
 */
public class index1 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "------>" + i);
            //毫秒
            Thread.sleep(1*1000);
        }
    }
}
