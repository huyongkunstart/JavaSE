package com.hu.c1.test3.i;

public class Bank {
	private Customer customers[]=new Customer[5];//也可以在构造器初始化
	private int numberOfCustomer;
	
	public Bank() {
//		customers= new Customer[10];
	}
	public void addCustomer(String f,String l) {
		Customer c1 = new Customer(f,l);
		customers[numberOfCustomer++]=c1;
	}
	public int getNumOfCustomers() {
		return numberOfCustomer;
	}
	public Customer getCustomer(int index) { 
	//	return customers[index];
		if(index >=0 && index <customers.length) {
			return customers[index];
		}
		return null;
	}
}

