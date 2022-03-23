package com.hu.b;

import java.util.Scanner;

public class index8_test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("请输入学生人数:");
		int n = scanner.nextInt();
		float gray[] = new float[n];
		float max=Float.MIN_VALUE;
		System.out.println("请输入"+n+"个学生成绩：");
		for (int i = 0; i < gray.length; i++) {
			gray[i] = scanner.nextFloat();
			if(gray[i]>max) {
				max=gray[i];
			}
		}
		System.out.println("最高分为:"+max);
		for(int i=0;i<gray.length;i++) {
			if(gray[i]>=max-10) {
				System.out.println("Student "+i+" score is "+gray[i]+" grade is A");
			}else if(gray[i]>=max-20) {
				System.out.println("Student "+i+" score is "+gray[i]+" grade is B");
			}else if(gray[i]>=max-30) {
				System.out.println("Student "+i+" score is "+gray[i]+" grade is C");
			}else {
				System.out.println("Student "+i+" score is "+gray[i]+" grade is D");
			}
		}
	}
}
