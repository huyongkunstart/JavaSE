package com.TeamSchedule.java2_单例设计模式;
//单例设计模式

/*
 * 
 * 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对
某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。
如果我们要让类在一个虚拟机中只能产生一个对象，我们首先必须将类的构 造器的访问权限设置为private，这样，就不能用new操作符在类的外部产生
类的对象了，但在类内部仍可以产生该类的对象。因为在类的外部开始还无
法得到类的对象，只能调用该类的某个静态方法以返回类内部创建的对象，
静态方法只能访问类中的静态成员变量，所以，指向类内部产生的该类对象
的变量也必须定义成静态的。
 */
public class SingletionTset1 {
	public static void main(String[] args) {
		Bank a = Bank.getInstance();
	}
}
 //饿汉式
class Bank{
	private Bank() {
		
	}
	
	private static Bank instance = new Bank();

	public static Bank getInstance() {
		return instance;
	}

}
