package com.hu.c1.test;

import java.io.PrintStream;

/*public class index5 {
	public static void main(String[] args) {
	int a=10;
	int b=10;
	//需要在method方法被调用后，仅打印出a=100,b=100,请写出method方法的代码
	method(a,b);
	System.out.println("a="+a);
	System.out.println("b="+b);
	}
}
*/

public class index4_test1 {

	public static void main(String[] args) {
		int a=10;
		int b=10;
		//需要在method方法被调用后，仅打印出a=100,b=100,请写出method方法的代码
		method(a,b);
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
	//方法一
	public static void method(int a,int b) {
		a=a*10;
		b=b*10;
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.exit(0);
	}
	
	//方法二
	public static void method2(int a,int b) {
		PrintStream ps = new PrintStream(System.out) {
			@Override
			public void println(String x) {
				if("a=10".equals(x)) {
					x="a=100";
				}else if("b=10".equals(x)) {
					x="b=100";
				}
				super.println(x);
			}
		};
		System.setOut(ps);
	}

	
}
