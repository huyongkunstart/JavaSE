package com.TeamSchedule.java5_代码块;
//代码块
//总结：由父及子 静态先行
class Root{
	static{
		System.out.println("Root的静态初始化块"); //1
	}
	{
		System.out.println("Root的普通初始化块"); //4
	}
	public Root(){
		System.out.println("Root的无参数的构造器"); //5
	}
}
class Mid extends Root{
	static{
		System.out.println("Mid的静态初始化块"); //2
	}
	{
		System.out.println("Mid的普通初始化块"); //6
	}
	public Mid(){
		super();
		System.out.println("Mid的无参数的构造器"); //7
	}
	public Mid(String msg){
		//通过this调用同一类中重载的构造器
		this();
		System.out.println("Mid的带参数构造器，其参数值：" //8
			+ msg);
	}
}

class Leaf extends Mid{
	static{
		System.out.println("Leaf的静态初始化块"); //3
	}

	{
		System.out.println("Leaf的普通初始化块"); //9
	}	
	public Leaf(){
		//通过super调用父类中有一个字符串参数的构造器
		super("AAA");
		System.out.println("Leaf的构造器"); //10
	}
}

public class LeafTest{
	public static void main(String[] args){
		System.out.println("1111111111111");
		new Leaf(); 
		System.out.println("**********");
		new Leaf(); 
	}
}

