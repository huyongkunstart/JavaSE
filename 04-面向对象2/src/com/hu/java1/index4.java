package com.hu.java1;

public class index4 {
	public static void main(String[] args) {
		Integer i =new Integer(1);
		Integer j =new Integer(1);
		System.out.println(i==j); //false
		
		Integer m=1;
		Integer n=1;
		System.out.println(m==n);  //true
		
		Integer x=128;
		Integer y=128;
		System.out.println(x==y);  //false
		//Integer内部定义了IntegerCache结构，里面定义了Integer[]
		//保存了[-128,127]范围的整数，如果给Interage赋值在这个范围,直接使用数组不会new对象，
		//不在这个范围就会new
		
	}
}
