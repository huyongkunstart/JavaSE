package com.hu.test2;

public class CykunderTest {
	public static void main(String[] args) {
		Cylinder a = new Cylinder();
		a.setRaduis(2);
		a.setLength(4);
		System.out.println("圆柱的体积为："+a.findVolume());
	}
}
