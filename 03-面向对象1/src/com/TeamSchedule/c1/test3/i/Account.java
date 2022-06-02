package com.TeamSchedule.c1.test3.i;
/**
写一个名为 Account 的类模拟账户。该类的属性和方法如下图所示。该类包括的属性：
账号 id，余额 balance，年利率 annualInterestRate；包含的方法：访问器方法（getter 和 setter
方法），取款方法 withdraw()，存款方法 deposit()。
 */
public class Account {
	private int id;
	private double balabce;
	private double annuallnterrestRate;
	

	public Account(int id, double balabce, double annuallnterrestRate) {
		super();
		this.id = id;
		this.balabce = balabce;
		this.annuallnterrestRate = annuallnterrestRate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalabce() {
		return balabce;
	}
	public void setBalabce(double balabce) {
		this.balabce = balabce;
	}
	public double getAnnuallnterrestRate() {
		return annuallnterrestRate;
	}
	public void setAnnuallnterrestRate(double annuallnterrestRate) {
		this.annuallnterrestRate = annuallnterrestRate;
	}
	
	//取钱
	public void withdraw(double amount) {
		if(this.balabce<amount) {
			System.out.println("余额不足,取款失败");
		}else {
			this.balabce-=amount;
			System.out.println("成功取出:"+amount);
		}
	}
	
	//存钱
	public void deposit(double amount) {
		this.balabce+=amount;
		System.out.println("成功存入:"+amount);
	}
	
}
