package com.TeamSchedule.java1;
//finally的使用
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyTest {
	
	@Test
	public void method() {
			FileInputStream fis=null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			
			int data = fis.read(); 
			while(data!= -1) {
				System.out.print((char)data);
				data = fis.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null) {
					fis.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	@Test
	public void test1() {
		try {
			int a=10;
			int b=0;
			System.out.println(a/b);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("一定执行");
		}
	}
}
