package com.hu.java5_代码块;

public class index2_代码块 {
	String nameString;
	int age;
	static String descString="我是一个人";
	//构造器
	public index2_代码块() {
		System.out.println("aaaaaaaaaa");
	}
	public index2_代码块(String nameString, int age) {
		super();
		this.nameString = nameString;
		this.age = age;
	}
	
	//静态代码块
	static{
		System.out.println("hello static");
	}
	//非静态代码块
	{
		System.out.println("hello");
	}
	
	
	//方法

	@Override
	public String toString() {
		return "index2_代码块 [nameString=" + nameString + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		index2_代码块 a=new index2_代码块();
		System.out.println("************");
		index2_代码块 b=new index2_代码块();
		
	}
	
}

