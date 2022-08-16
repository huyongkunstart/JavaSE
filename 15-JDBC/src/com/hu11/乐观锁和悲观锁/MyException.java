package com.hu11.乐观锁和悲观锁;

public class MyException extends RuntimeException{
	static final long serialVersionUID = -7034897190745766939L;
	public MyException() {
		super();
	}

	public MyException(String args) {
		System.err.println(args);
	}
}
