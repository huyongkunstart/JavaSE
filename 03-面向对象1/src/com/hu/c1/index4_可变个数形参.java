package com.hu.c1;

public class index4_可变个数形参 {

	public static void main(String[] args) {
		//以前没有可变个数形参是用数组
		A test = new A();
		test.show(1,new String[] {"aa","bb","cc"});
		//现在直接使用
		test.show(1,"aa","bb","cc");
	}
}

class A{
	public void show(String a) {
		
	}
	//相当于数组,使用可变个数参数方法，它必须放在最后
	public void show(int x,String ... a) { 
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	/*
	 * public void show(String [] a) {
	 * 
	 * }
	 */
}
