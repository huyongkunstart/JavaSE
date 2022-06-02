package com.TeamSchedule.java1;
//常见异常

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;



public class ExceptionTest {

//****************编译时异常(checked)
//	@Test
//	public void test7() {
//		File file = new File("hello.txt");
//		FileInputStream fis = new FileInputStream(file);
//		
//		int data = fis.read();
//		while(data!= -1) {
//			System.out.print((char)data);
//			data = fis.read();
//		}
//		fis.close();
//	}
	
	
	
//****************运行时异常(unchecked RuntimeException)

//ArithmeticException  //算数异常
	@Test
	public void test6() {
		int a=10;
		int b=0;
		System.out.println(a/b);
	}
	
	
//InputMismatchException  //输入不匹配异常
	@Test
	public void test5() {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		System.out.println(score);
	}
	
	
//NumberFormatException // 数字转换异常
	@Test
	public void Test4() {
		String str = "123";
		str="abc";
		int num= Integer.parseInt(str);
	}
	
//classCaseException  类型转换异常
	@Test
	public void test3() {
		Object object = new Date();
		String str = (String) object; 
	}
	
	
	
//ArrayIndexOutOfBoundsException 数组越界
	@Test
	public void test2() {
		int [] arr= new int[10];
		System.out.println(arr[10]);
	}
	
	
//NullpointerException   空指针异常
	@Test 
	public void test1() {
//		int [] arr = null;
//		System.out.println(arr[4]);
		
		String str = "abc";
		str = null;
		System.out.println(str.charAt(0));
		
	}
	
	
	
	
}
