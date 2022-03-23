package com.hu.c1.test3;

public class Test {
	public static void main(String[] args) {
		Customer c1 = new Customer("Jane","Smith");
		c1.setAccount(new Account(1000,2000,0.0123));
		c1.getAccount().deposit(100);
		c1.getAccount().withdraw(2000);
		c1.show();
	}
}
