package com.hu.java;

public class supertest {
	public static void main(String[] args) {
		Object a = new Person();
		System.out.println(a.getClass());
		System.out.println(a instanceof Person);
		System.out.println(a instanceof Student);
		System.out.println(a instanceof Object);
	}
}
