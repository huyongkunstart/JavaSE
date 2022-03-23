package com.hu.java1;
// 异常处理机制一：try-catch-finally
import org.junit.Test;

public class ExceptionTest1 {
	
	
	@Test 
	public void Test4() {
		String str = "123";
		str="abc";
		try {
			int num= Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("出现数值转换异常");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("出现空指针异常");
		}
		 
		
	}
	
	
	
	
}
