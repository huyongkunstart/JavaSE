package com.TeamSchedule.test6_equals;
/*
 * 编写Order类，有int型的orderId，String型的orderName，相应的
getter()和setter()方法，两个参数的构造器，重写父类的equals()方法：
public boolean equals(Object obj)，并判断测试类中创建的两个对象是否
相等
 */
public class Order {
	private int orderly;
	private String orderName;
	public Order(int orderly, String orderName) {
		super();
		this.orderly = orderly;
		this.orderName = orderName;
	}
	public int getOrderly() {
		return orderly;
	}
	public void setOrderly(int orderly) {
		this.orderly = orderly;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Order other = (Order) obj;
//		if (orderName == null) {
//			if (other.orderName != null)
//				return false;
//		} else if (!orderName.equals(other.orderName))
//			return false;
//		if (orderly != other.orderly)
//			return false;
//		return true;
//	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		if (orderly != order.orderly) return false;
		return orderName != null ? orderName.equals(order.orderName) : order.orderName == null;
	}

}
