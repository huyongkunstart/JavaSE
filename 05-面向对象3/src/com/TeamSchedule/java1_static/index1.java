package com.TeamSchedule.java1_static;
//static 关键字
public class index1 {
	public static void main(String[] args) {
		Person.a=12;
		System.out.println(Person.a);
		Person a1= new Person();
		System.out.println(a1.a);
	}
}

class Person{
	static int a;
}

