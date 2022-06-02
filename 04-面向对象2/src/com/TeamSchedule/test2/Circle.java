package com.TeamSchedule.test2;

public class Circle {
	private double raduis;

	public Circle() {
		raduis=1;
	}
	public double getRaduis() {
		return raduis;
	}

	public void setRaduis(double raduis) {
		this.raduis = raduis;
	}
	
	public double finArea() {
		return Math.PI*raduis*raduis;
	}
	
	
}
