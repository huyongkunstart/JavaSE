package com.hu.java2_单例设计模式;

public class test1 {
	public static void main(String[] args) {
		A a = A.geta();
	}
}

//饿汉式单例设计模式
class A{
	private A() {
		
	}
	private static A a = new A();
	
	public static A geta() {
		return a;
	}
}

//懒汉式单例设计模式
class B{
	private B() {
		
	}
	
	private static B b = null;
	
	public static B getb() {
		if(b == null) {
			return b= new B();
		}
		return b;
	}
}
