package com.TeamSchedule.test3_抽象类;
/*
 * MyDate类包含:
	private成员变量year,month,day ；
	toDateString()方法返回日期对应的字符串：xxxx年xx月xx日
 */
public class MyDate {
	private int year;
	private int moth;
	private int day;
	
	public MyDate(int year, int moth, int day) {
		super();
		this.year = year;
		this.moth = moth;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMoth() {
		return moth;
	}

	public void setMoth(int moth) {
		this.moth = moth;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String toDateString() {
		return year+"年"+moth+"月"+day+"日";
	}
}
