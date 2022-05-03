package com.hu.java;

public class Student extends Person{
	String major;


	public Student() {
		super();
	}
	public Student(String major) {
		this.major = major;
	}
	
	@Override
	public void eat() {
		System.out.println("学生多吃有营养的事务");
	}
	public void walk() {
		super.eat();
		eat();
		System.out.println("学生学习知识");
	}
	private void show() {
		// TODO Auto-generated method stub
		
	}
	
}
