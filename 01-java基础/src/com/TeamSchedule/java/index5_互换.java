package com.TeamSchedule.java;
//互换
public class index5_互换 {

	public static void main(String[] args) {
		//方法一
		//int a=1,b=2; //局限性，只能用于数值互换
		//a=a+b;
		//b=a-b;
		//a=a-b;
		
		//方法二
		int a=1,b=2;
		int c;
		c=a;
		a=b;
		b=c;
		System.out.println(a+" "+b);	
		
		//方法三   使用位运算符
		//局限性，只能用于数值互换
		int x=1,y=2;
		x=x^y;
		y=x^y;
		x=x^y;
		System.out.print(x+" "+y);

	}

}
