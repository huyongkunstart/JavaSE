package com.hu.java;

public class index2 {
	public static void main(String[] args) {
		Animal a = new Dog();
		//a.name(); 错误，不能用
		//Cat c = (Cat)a; //编译通过，运行不通过,a本质上是Dog类
		Dog b = (Dog)a;
		System.out.println((b instanceof Dog)); //true
		b.name();               //Dog
		
	}
}

class Animal{
	String name;
	int age;
	
	public void show() {
		System.out.println("1111");
	}
	
}

class Dog extends Animal{
	public void name() {
		System.out.println("Dog");
	}
	@Override
	public void show() {
		System.out.println("2222");
	}
}

class Cat extends Animal{
	public void name() {
		System.out.println("cat");
	}
	@Override
	public void show() {
		System.out.println("3333");
	}
}

