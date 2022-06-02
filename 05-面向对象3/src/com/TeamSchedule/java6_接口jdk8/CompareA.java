package com.TeamSchedule.java6_接口jdk8;
/*
 * 
 * jdk8以后，接口除了可以定义全局常量和抽象方法外，还
 * 可以定义静态方法，默认方法
 */
interface CompareA {
	//静态方法
	public static void method1() {
		System.out.println("接口A中的静态方法method1()");
	}
	
	//默认方法
	public default void method2() { //public 可以省略
		System.out.println("接口A中的默认方法method2()");
	}
	default void method3()
	{
		System.out.println("接口A中的默认方法method3()");
	}
}
