package com.hu.b;

public class index9_二维数组定义 {

	public static void main(String[] args) {
		// 二维数组的声明和初始化

		// 静态初始化
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9, 0 } };

		// 动态初始化
		int[][] arr1 = new int[3][2];
		
		int[][] arr2 = new int[3][];
		arr2[0]=new int[3];
		//类型推断
		int [][] arr3= { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9, 0 } };
		
		//调用
		System.out.println(arr.length); //3
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		//二维数组默认值
		int[][] a=new int[3][2];
		System.out.println(a[1]); //[I@15db9742  地址值
		System.out.println(a[0][0]); // 0
		
		int[][] b=new int[4][];
		System.out.println(b[0]); //null  因为没有初始化，所以为NULL
	}

}
