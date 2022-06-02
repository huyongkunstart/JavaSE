package com.TeamSchedule.java;
//求0到100之间的质数
public class index7_求质数 {

	public static void main(String[] args) {
		int count=0;
		label:for(int i=2;i<=100;i++) {	
			  	for(int j=2;j<=Math.sqrt(i);j++) { //Math.sqrt(i)表示根号i
			  		if(i%j==0) {
						continue label;
					}
				}
				count++;
			System.out.println(i);
		}
		System.out.println("count="+count);

	}




}

