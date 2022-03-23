package com.hu.java;
import java.util.Scanner;
public class index2 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串");
		Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);
 
        System.out.println("请输入一个int数字");
        int x = sc.nextInt(); 
        System.out.println(x);
 
        System.out.println("请输入一个double数字");
        double y = sc.nextDouble();
        System.out.println(y);
    }
}

