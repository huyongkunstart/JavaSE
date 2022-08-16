package com.TeamSchedule.java1;

public class index3_包装类 {
	private static final boolean True = false;

	public static void main(String[] args) {
		//基本数据类型转换为包装类
		int a=12;
		Integer a1=new Integer(a);
		System.out.println(a1.toString()); //12
		
		String c="12345";
		Integer c1 = new Integer(c);
		System.out.println(c1.toString());//12345		
		
		//包装类转换为基本数据类型
		Integer b1= new Integer(12);
		int b2 = b1.intValue();
		System.out.println(b2);
		
		//自动装箱
		int num1=10;
		Integer num2=num1;
		System.out.println(num2.toString());
		
		//自动拆箱
		Integer aaa= new Integer(12);
		int bbb=aaa;
		System.out.println(bbb);
		
		//基本数据类型、包装类---->String类型
		int q=10;
		Double w=new Double(12.4);
		//方式一
		String q1=q+" ";
		//方式二
		String q2 = String.valueOf(q);
		String w1 = String.valueOf(w);
		
		
		//String类型---->基本数据类型、包装类
		
		String qqq="123";
		int qqq1 = Integer.parseInt(qqq);
		
		
		Object pObject=true ? new Integer(1):new Double(2.0);
		System.out.println(pObject);
	}
	
}
