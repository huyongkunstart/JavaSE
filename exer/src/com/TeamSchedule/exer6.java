package com.TeamSchedule;

import org.junit.Test;

import java.util.Scanner;

public class exer6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入若干单词，以空格作为分隔");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            System.out.println("键盘输入的内容是：" +sc.nextBoolean());
        }
        System.out.println("执行吗");

    }
    @Test
    public void test1(){
        int[] a = new int[5];
        System.out.println(a.length);
    }
}
