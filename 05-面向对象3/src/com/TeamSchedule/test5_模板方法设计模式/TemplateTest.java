package com.TeamSchedule.test5_模板方法设计模式;

public class TemplateTest {
	public static void main(String[] args) {
		SubTemplate a = new SubTemplate();
		a.spendTime();
	}
}

abstract class Template{
	
	
	public void spendTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		
		System.out.println("花费的时间为:"+(end - start));
	}
	
	public abstract void code();
}

class SubTemplate extends Template{

	@Override
	public void code() {
		lable:for(int i=2;i<=1000;i++) {
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					continue lable;
				}
			}
			System.out.println(i+"是一个质数");
		}
		
	}
	
}
