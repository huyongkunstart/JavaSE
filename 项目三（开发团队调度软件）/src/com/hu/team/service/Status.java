package com.hu.team.service;
/*
 * 表示员工三种状态
 */
//public class Status {
//	private final String NAME;
//	private Status (String name) {
//		this.NAME = name;
//	}
//
//	public static final Status FREE = new Status("FREE");
//	public static final Status BUSY = new Status("BUSY");
//	public static final Status VOCATION = new Status("VOCATION");
//	public String getNAME() {
//		return NAME;
//	}
//	@Override
//	public String toString() {
//		return NAME;
//	}
//}
//使用枚举类来实现
public enum Status{
	FREE,BUSY,VOCATION;
}