package com.hu.c1.test3;

public class Customer{
	private String firstName;
	private String lastName;
	private Account account;
	public Customer() {

	}

	public Customer(String f,String l) {
		this.firstName=f;
		this.lastName=l;
		
	}
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void show() {
		System.out.println("Customer ["+firstName+", "+lastName+"] has a account: id is "+account.getId()+", annuallinterestRate is "+account.getAnnuallnterrestRate()*100+"%, balance is "+account.getBalabce());
	}
	
	
}

