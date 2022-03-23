package com.hu.c1.test2;

public class BoyGileTest {
	public static void main(String[] args) {
		Boy boy = new Boy("hu", 23);
		Girl girl = new Girl("dan", 18);
		
		boy.shout();
		girl.marry(boy);
		
	}
}
