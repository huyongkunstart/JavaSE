package com.TeamSchedule.java7_内部类;
//局部内部类使用的一个注意点


public class InnerClass3 {
	/*
	 * 在局部内部类的方法中（比如show） 如果调用局部内部类所声明的方法（比如 method）中的局部变量（比如num）的话
	 * 要求此局部变量声明为final的
	 * 
	 * jdk 7 之前的版本，要求此局部变量显示的声明为final
	 * jdk 8 及版本以后，可以省略final的声明
	 */
	public void method() {
		//局部变量 
		final int num=10; //final可以省略
		
		class AA{
		
			
			public void show() {
	//			num=20;
				System.out.println(num);
			}
		}
		
		
	}
	
	
}
