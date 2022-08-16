package com.TeamSchedule.c1.test;

//定义一个int型数组:int[] arr = new int[] {12,3,3,34,56,77,432};
//让数组的每个位置上的值除以首位置的元素，得到的结果，作为该位置上的新值。遍历新的数组

import java.io.PrintStream;

public class index4_test2 {
	public static void main(String [] args) {
		int[] arr = new int[] {12,3,3,34,56,77,432};
		
		//方法一
		for(int i=arr.length-1;i>=0;i--) {
			arr[i]=arr[i]/arr[0];
		}
		//方法二
		int temp=arr[0];
		for(int i=0;i<arr.length;i++) {
			arr[i]=arr[i]/temp;
		}
		
		
		//=======================================
		
		int a[] = new int[] {1,2,3};
		System.out.println(a); //地址值
		char b[] = {'a','b','c'};
		System.out.println(b);  //abc
		System.out.println("char: " + b); //char: [C@677327b6
		String c[] = new String[] {"asd","drtgr","pppp"};
		System.out.println(c); // 地址值
		boolean[] d = new boolean[]{true,false};
		System.out.println(d);
	}
}
