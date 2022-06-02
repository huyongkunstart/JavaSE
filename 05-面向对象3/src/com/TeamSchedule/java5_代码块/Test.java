package com.TeamSchedule.java5_代码块;
/**
 * @author shkstart
 * @create 2022-05-03 13:56
 * @description：
 */
public class Test {
    private int a;
    {
        a = 12;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.a);
    }
}

