package com.hu.java5_代码块;
//代码块
class Father {
	static {
		System.out.println("11111111111"); //1
	}
	{
		System.out.println("22222222222");
	}

	public Father() {
		System.out.println("33333333333");

	}

}

public class Son extends Father {
	static {
		System.out.println("44444444444"); //2
	}
	{
		System.out.println("55555555555");
	}
	public Son() {
		System.out.println("66666666666");
	}


	public static void main(String[] args) { // 由父及子 静态先行
		System.out.println("77777777777");
		System.out.println("************************");
		new Son();
		System.out.println("************************");
//
		new Son();
		System.out.println("************************");
		new Father();
	}

}
