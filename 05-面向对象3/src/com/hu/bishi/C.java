package com.hu.bishi;
//面试题

interface A{
	public static final int x=0;
}
class B{
	int x =1;
}


public class C extends B implements A {
	public void pX() {
		//System.out.println(x); 报错
		System.out.println(super.x); //B中的x
		System.out.println(A.x);   //A中的x
	}
	public static void main(String[] args) {
		new C().pX();
	}
}
