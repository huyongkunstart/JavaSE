package com.hu.java;
//求0到100之间的质数 2 3 5
public class index6_质数 {

	public static void main(String[] args) {
		int count=0;
		for(int i=2;i<=100;i++) {
			boolean a=true;		
			for(int j=2;j<=Math.sqrt(i);j++) { //Math.sqrt(i)表示根号i
				if(i%j==0) {
					a=false;
					break;
				}
			}
			if(a==true) {

				count++;				
			}		
		}
		System.out.println(count);

	}

}
