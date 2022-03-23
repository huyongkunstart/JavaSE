package com.hu.java;

import java.util.Scanner;
public class index4 {
    public static void main(String[] args) {
        while (true) {
                System.out.println("请输入一个int数字");
                Scanner sc=new Scanner(System.in);
                if(sc.hasNextInt()) {	
	                int x = sc.nextInt();
	                System.out.println(x);
                }
                else {
                	System.out.println("输入错误，请重新输入");
                }
                
            }
        }
    }

