package com.TeamSchedule.b;

import java.util.Arrays;

//数组定义
public class index1_一维数组定义 {

	public static void main(String[] args) {
		int a[] = new int[3]; // 1.动态初始化 数组初始化和赋值分开操作
		a[0] = 1;

		int b[] = new int[] { 1, 2, 3, 4 }; // 2.静态初始化 数组初始化和赋值一起进行

		String c[] = { "ass", "sedfd" };
		// 3.类型推断
		int [] d= {1,3,4,5};

		System.out.println(c[1]);
		System.out.println(a.length);
		System.out.println(b.length);
		System.out.println(Arrays.toString(b));


			
	}

}
