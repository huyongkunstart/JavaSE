package com.hu.java6_接口jdk8;
//接口中定义的静态方法，只能通过接口来调用，它的实现类不能使用
//接口中的默认方法，可以通过接口实现类的对象来调用,实现类可以重写接口中的默认方法
public class CompareATest {
	public static void main(String[] args) {
		Subclass s = new Subclass();
		s.method3();
		s.method();
		CompareA.method1(); //接口调用静态方法
		s.method2(); //接口实现类的对象调用默认方法
	}
}
 class Subclass implements CompareA,CompareB{
	 
	 public void method() {
		 method3();
		//实现类中调用接口中的默认方法
		 CompareA.super.method3();
		 CompareB.super.method3();
	 }

	@Override
	public void method3() {
		System.out.println("实现类重写的method3方法");
	} 
 }