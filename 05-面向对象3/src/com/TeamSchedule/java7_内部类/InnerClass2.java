package com.TeamSchedule.java7_内部类;
/*
 * 局部内部类
 */

public class InnerClass2 {

	
	public void method() {
		//局部内部类
		class AA{
			
		}
	}
	
	//返回一个实现了Comparable接口的对象
	public Comparable  getComparable() {
	//	方式一：
	/*
	 * class MyComparable implements Comparable{
	 * 
	 * @Override public int compareTo(Object o) { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * }
	 * 
	 * return new MyComparable();
	 */
		
	
	  //方式二
		return new Comparable() {
			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		
		
		
		
	}
	
	
	
}
