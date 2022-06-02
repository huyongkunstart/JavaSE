package com.TeamSchedule.java;

public class supertest {
	public static void main(String[] args) {
		Object a = new Person();
		System.out.println(a.getClass());
		System.out.println(a instanceof Person); //true
		System.out.println(a instanceof Student);//false
		System.out.println(a instanceof Object); //true
	}
}
