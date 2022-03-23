package com.hu.test5多态;

/**
 * 定义三个类，父类GeometricObject代表几何形状，
 * 子类Circle代表圆形，MyRectangle代表矩形。
定义一个测试类GeometricTest，
编写equalsArea方法测试两个对象的面积是否相等（注意方法的参数类型，利用动态绑定技术），
编写displayGeometricObject方法显示对象的面积（注意方法的参数类型，利用动态绑定技术）
 */
public class GeometricTest {
	public static void main(String[] args) {
		GeometricTest a = new GeometricTest();
		Circle a1 = new Circle(4.0,"red", 1.0);
		a.displayGeometricObject(a1);
	}
	
	
	public boolean equalsArea(GeometricObject a,GeometricObject b) {
		return a.findArea()==b.findArea();
	}
	
	public void displayGeometricObject(GeometricObject e) {
		System.out.println(e.findArea());
	}
}
