package com.hu.c1;

public class index3_重载 {

	public static void main(String[] args) {
		System.out.println(getSum(1,3));
		System.out.println(getSum(1.2f,3.2f));

	}
	
	public static int getSum(int x,int y) {
		return x+y;
	}
	public static float getSum(float x,float y) {
		return x+y;
	}

}
