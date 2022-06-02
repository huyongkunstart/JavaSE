package com.TeamSchedule.java7_内部类;

/*
 * 内部类
 * 1.java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类
 * 2.内部类分类：成员内部类（静态和非静态） 和 局部内部类（方法内，代码块内，构造器内）
 * 3.成员内部类
 * 		一方面 作为外部类的成员
 * 			》可以调用外部类的结构
 * 			》可以被static修饰
 * 			》可以被四种不同权限修饰
 * 		另一方面 作为一个类
 * 			》类内可以定义属性，方法，构造器，代码块等
 * 			》可以被final修饰，表示此类不能被继承，不用final可以被继承
 * 			》可以被abstract修饰
 * 
 * 4.关注如下3个问题
 *    1.如何实例化成员内部类的对象
 *    2.如何在成员内部类中区分调用外部类的结构
 *    3.开发中局部内部类的使用
 * 
 */
public class InnerClass {
	public static void main(String[] args) {
		//静态成员内部类
		Person.Dog dog = new Person.Dog();
		dog.show();
		
		//非静态成员内部类
		//Person.Bird Bird = new Person.Bird(); //错误
		Person p = new Person(12,"单");
		Person.Bird bird = p.new Bird();
		bird.show();
		bird.display("胡");
		
		System.out.println("************************");
		
	}
}

class Person{
	
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	int age;
	String name;
	public void eat() {
		System.out.println("吃吃");
	}
	
	//静态成员内部类
	static class Dog{
		int age;
		String name;
		public void show() {
			System.out.println("狗叫");
		} 
	}
	
	//非静态成员内部类
	class Bird{
		int id;
		String name;
		
		public Bird() {

		}

		public void show() {
			System.out.println("hhh");
			//调用外部类的非静态属性
			Person.this.eat(); //等同于 eat()
		} 
		
		public void display(String name) {
			System.out.println(name); //方法的形参
			System.out.println(this.name); //bird内部类的属性
			System.out.println(Person.this.name);//Person外部类的非静态属性
			
		}
		
	
	}
	
	
	
	public void method() {
		//局部内部类
		class AA{
			
		}
	}
	
	{ //代码块
		//局部内部类
		class BB{
					
		}
	}
}
