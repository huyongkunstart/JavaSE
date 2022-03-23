package com.hu.bishi;

public class ObjectTest {
	public static void main(String[] args) {
		ObjectTest a = new ObjectTest();
		a.test();

		
	}
	public void test() {
			char[] arr = new char[] { 'a', 'b', 'c' };
			System.out.println(arr);// abc
			String[] arr3 = new String[] {"qwe","qwefdsf"};
			System.out.println(arr3); //[Ljava.lang.String;@123a439b
			int[] arr1 = new int[] { 1, 2, 3 };
			System.out.println(arr1);//[I@123a439b
			double[] arr2 = new double[] { 1.1, 2.2, 3.3 };
			System.out.println(arr2);//[D@7de26db8
			}
}
