package com.hu.java2;

public class equals重写 {
	public static void main(String[] args) {
		Order a1 = new Order(1,"aa");
		Order a2 = new Order(2,"bb");
		Order a3 = new Order(2,"bb");
		System.out.println(a1.equals(a2));
		System.out.println(a2.equals(a3));
	}
	
	
	
}


class Order{
	private int orderId;
	private String orderName;
	public Order() {
		super();
	}
	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
//		order other = (order) obj;
//		if (orderId != other.orderId)
//			return false;
//		if (orderName == null) {
//			if (other.orderName != null)
//				return false;
//		} else if (!orderName.equals(other.orderName))
//			return false;
//		return true;
//	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Order) {
			Order order= (Order) obj;
			return this.orderId == order.orderId &&
					this.orderName.equals(order.orderName);	
		}
		return false;
	}
	
}


