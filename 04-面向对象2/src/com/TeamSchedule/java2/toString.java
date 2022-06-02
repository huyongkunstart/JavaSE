package com.TeamSchedule.java2;

public class toString {
	public static void main(String[] args) {
		Circle c1 = new Circle(2.3);
		Circle c2 = new Circle("white",1.1,2.3);
		System.out.println("判断颜色是否相等:"+c1.color.equals(c2.color));
		System.out.println("判断半径是否相等:"+c1.equals(c2));
		
	}
}

class GeometicObject{
	protected String color;
	protected double weight;
	public GeometicObject() {
		super();
		this.color="red";
		this.weight=1.0;
	}
	public GeometicObject(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
}

class Circle extends GeometicObject{
	private double radius;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(String color, double weight, double radius) {
		super(color, weight);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double finArea() {
		return Math.PI * radius * radius;

	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Circle other = (Circle) obj;
//		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
//			return false;
//		return true;
//	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Circle) {
			Circle circle = (Circle) obj;
			return this.radius == circle.radius;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Circle{" +
				"radius=" + radius +
				'}';
	}
//	@Override
//	public String toString() {
//		return "Circle [radius=" + radius + "]";
//	}



}
