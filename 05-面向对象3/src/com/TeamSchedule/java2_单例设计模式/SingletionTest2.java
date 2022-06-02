package com.TeamSchedule.java2_单例设计模式;

public class SingletionTest2 {
	public static void main(String[] args) {
		Order order1 = Order.getInstance();
	}
}

//懒汉式
class Order{
	private Order() {
		
	}
	
	private static Order instance = null;
	
	public static Order getInstance() {
		if(instance == null) {
			instance = new Order();
		}
		return instance; 
	}
}