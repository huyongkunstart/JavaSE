package com.hu.c1;

//匿名对象的使用
public class index2_匿名对象 {
	public static void main(String[] args) {
		PhoneMall mall = new PhoneMall();
		mall.show(new Phone());
	}
}

class PhoneMall {

	public void show(Phone phone) {
		phone.sendEmail();

		phone.playGame();
		phone.showPrice();
	}
}

class Phone {
	double price; // 价格

	public void sendEmail() {
		System.out.println("发送邮件");
	}

	public void playGame() {
		System.out.println("玩游戏");
	}

	public void showPrice() {
		System.out.println("价格为:" + price);
	}
}
