package com.hu.b;
import java.util.Arrays;
public class index14_Arraystest {
	public static void main(String[] args) {
		//boolean equals(int a[],int b[])
		int x[] = new int[] {1,2,4,5};
		int y[] = new int[] {1,2,4,5};
		boolean flag=Arrays.equals(x, y); //重写的equals方法 
		System.out.println(flag);
		
		//String toString(int[] a)
		int[] arr=new int[] {2,3,56,435,2,0};
		System.out.println(Arrays.toString(arr));
	
		//void fill(int[] a,int val)  填充到数组
		int [] arr1 = new int[] {22,33,55,66};
		Arrays.fill(arr1, 77);
		System.out.println(Arrays.toString(arr1));
		// [77, 77, 77, 77]
		
		
		// void sort(int[] a)  对数组进行排序
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		//int binarySearch(int[] a,int key) 二分法检索查找
		System.out.println(Arrays.binarySearch(arr, 56));
	}
	
	
}
