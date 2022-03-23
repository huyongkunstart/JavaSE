package com.hu.java;
//判断1000以内的所有完数(恰好等于它的因子之和，除了本身)
public class index8_完数 {

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			int sum = 0;
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) {
					sum += j;
				}
			}
			if (sum == i) {
				System.out.println(i + "是完数");
			}

		}

	}
}
