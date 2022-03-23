package com.hu.java1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//4.异常处理机制二：throws
public class ExceptionTest2 {
	public static void main(String[] args) {
		try {
			method2();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void method2() throws IOException,FileNotFoundException {
		method1();
	}
	
	public static void method1() throws FileNotFoundException,IOException{
		File file = new File("hello.txt");
		FileInputStream fis = new FileInputStream(file);
		
		int data = fis.read();
		while(data!= -1) {
			System.out.print((char)data);
			data = fis.read();
		}
		fis.close();
	}
}
