package com.TeamSchedule.c1;

public class index5_递归 {

	public static void main(String[] args) {
		System.out.println(SUM(100));
	}
	//计算1-100之间的和
	public static int SUM(int num) {
		if(num == 1) {
			return 1;
		}else {
			return num+SUM(num-1);
		}	
	}

}
