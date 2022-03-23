package com.hu.test1;

public class ManKind {
	int sex;
	int salary;
	
	public void manOrWoman() {
		if(sex==1) {
			System.out.println("man");
		}else if(sex==0){
			System.out.println("woman");
		}
	}
	public void employeed() {
		if(salary==0) {
			System.out.println("no job");
		}else{
			System.out.println("job");
		}
	}
}
