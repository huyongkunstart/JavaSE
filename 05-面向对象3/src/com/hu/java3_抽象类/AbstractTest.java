package com.hu.java3_抽象类;

//一旦类被抽象，就不可以被实例化
public class AbstractTest {
	public static void main(String[] args) {
		
		//非匿名类匿名对象
		method(new Student());
		System.out.println("**********");
		
		
		//非匿名类非匿名对象
		Persons student = new Student();
		method(student);
		System.out.println("**********");
		
		
		//创建了一匿名子类的对象：p
		Persons p = new Persons() {
			@Override
			public void eat() {
				System.out.println("人没有吃饭");
				
			}
			@Override
			public void walk() {
				System.out.println("人已经走了");
				
			}
		};
		method(p);		
		System.out.println("**********");
		
		
		//匿名子类匿名对象
		method(new Persons() {
			
			@Override
			public void walk() {
				System.out.println("1111111");
				
			}
			
			@Override
			public void eat() {
				System.out.println("222222");
				
			}
		});
				
	}
	
	public static void method(Persons a) {
		a.walk();
		a.eat();
	}
}

abstract class Persons{
	String name;
	int age;
	
	public Persons() {

	}
	public Persons(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public abstract void eat();
	public abstract void walk();
}

class Student extends Persons{

	@Override
	public void eat() {
		System.out.println("人吃饭");
		
	}

	@Override
	public void walk() {
		System.out.println("人走了");
		
	}
	
}
