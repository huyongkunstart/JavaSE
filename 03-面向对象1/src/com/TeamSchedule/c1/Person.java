package com.TeamSchedule.c1;
//实例方法
/**
 * 
* @Description
* @author hu Email:3300786078@qq.com
* @version jdk1.8
* @date 2021年8月27日下午5:08:24
*
 */
public class Person {
	
	String name;
	int age;
	String sex;
	

	public static void main(String[] args) {
		Person P1=new Person();
		P1.age=20;
		System.out.println(P1.age);
		P1.study();
		P1.showAge();
		P1.addAge();

	}
	
	void study() {
		System.out.println("studying");
	}
	
	void showAge() {
		System.out.println(this.age);
	}
	
	void addAge() {
		this.age+=2;
		System.out.println(this.age);
	}

}

