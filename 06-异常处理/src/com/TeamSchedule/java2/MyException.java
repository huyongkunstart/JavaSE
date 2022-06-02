package com.TeamSchedule.java2;
//用户自定义异常类
/*
 * 1.继承于现有的异常结构：RuntimeException和Exception
 * 2.提供全局常量：serialVersionUID
 * 3.提供重载的构造器
 */
public class MyException extends RuntimeException{ //通常继承RuntimeException 和 Exception
	static final long serialVersionUID = -7034897190745766939L;
	
	public MyException() {
		
	}
	public MyException(String msg) {
		super(msg);
	}
}
