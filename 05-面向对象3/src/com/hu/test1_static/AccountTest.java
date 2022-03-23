package com.hu.test1_static;

public class AccountTest {
	public static void main(String[] args) {
		Account a1 = new Account();
		Account a2 = new Account("abcd",2000);
		
		Account.setInterestRate(0.0123);
		
		System.out.println(a1);
		System.out.println(a2);
	}
}
