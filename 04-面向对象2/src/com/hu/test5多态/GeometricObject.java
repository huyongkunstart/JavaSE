package com.hu.test5多态;

public class GeometricObject {  //几何图形
	private String color;
	private double weight;
	
	public GeometricObject(String color, double weight) {
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double findArea() {
		
		return weight;
	}
	
}



class Circle extends GeometricObject{ //圆
	private double radius;
	
	public Circle(double radius,String color, double weight) {
		super(color, weight);
		this.radius=radius;
	} 
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double findArea() {
		
		return 3.14*radius*radius;
	}
	
}


class MyRectangle extends GeometricObject{ //矩形
	private double width;
	private double height;
	
	public MyRectangle(String color, double weight, double width, double height) {
		super(color, weight);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double findArea() {
		
		return width*height;
	}
	
}
