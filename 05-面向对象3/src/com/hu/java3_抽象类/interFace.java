package com.hu.java3_抽象类;

public class interFace{
	public static void main(String[] args) {
		Plane play = new Plane();
		play.aaa();
	}
	
}

interface Fly{
	int a=10; //public static final 可以省略不写
	public static final int b=11;	
	//抽象方法
	public abstract void aaa();
	//静态方法
	public static void qqq() {
		System.out.println("你好");
	}
}

class Plane implements Fly{

	@Override
	public void aaa() {
		System.out.println("aaaaaaaaaa");
	}
	
}