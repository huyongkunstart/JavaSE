package com.hu2.java1;

/**
 * @author shkstart
 * @create 2022-05-05 15:16
 * @description：
 */
public class index2 {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        aaa.show();
    }
}


class AAA{
    public final void show(){
        System.out.println("final修饰的方法");
    }
}
