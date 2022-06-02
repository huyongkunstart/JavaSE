package com.TeamSchedule.c1.test3.i;

public class BankTest {

	public static void main(String[] args) {
		Bank b1=new Bank();
		b1.addCustomer("hu", "yongkun");
		
		b1.getCustomer(0).setAccount(new Account(1,2000,0.0123));
		b1.getCustomer(0).getAccount().withdraw(500);//取钱
		double yue=b1.getCustomer(0).getAccount().getBalabce();
		System.out.println("余额为："+yue);
		
		System.out.println(b1.getNumOfCustomers());
		System.out.println(b1.getCustomer(0));
	}
}


