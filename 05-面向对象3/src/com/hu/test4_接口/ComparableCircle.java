package com.hu.test4_接口;
/*
 * 定义一个ComparableCircle类，
 * 继承Circle类并且实现CompareObject接口。
 * 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半
径大小。
 */
public class ComparableCircle extends Circle implements CompareObject {
	
	public ComparableCircle(double radius) {
		super(radius);
	}

	@Override
	public int compareTo(Object o){
		if(this == o) {
			return 0;
		}
		if(o instanceof ComparableCircle) {
			ComparableCircle c = (ComparableCircle)o;
			
			if(this.getRadius()> c.getRadius()) {
				return 1;
			}else if(this.getRadius()< c.getRadius()) {
				return -1;
			}
			else {
				return 0;
			}
		}else {
			throw new RuntimeException("输入的数据类型不一致");
		}
		
	}
	
	
	

}
