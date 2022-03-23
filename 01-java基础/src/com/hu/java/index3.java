//当你想接收一个整数时，在控制台输入了一个非整数，
//比如：a，这时就会抛出 java.util.InputMismatchException异常。 
//1、进行异常处理
package com.hu.java;
import java.util.Scanner;
public class index3 {
    public static void main(String[] args) {
        while (true) {
            try {
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
                break;
            } catch (Exception e) {
                System.out.println("输入错误，请重新输入");
            }
        }
    }
}

