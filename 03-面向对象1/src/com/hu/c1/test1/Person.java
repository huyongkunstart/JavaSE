package com.hu.c1.test1;

public class Person {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>0 && age <=180) {
			this.age = age;
		}else {
			this.age=0;
		}
		
	}
	
}
