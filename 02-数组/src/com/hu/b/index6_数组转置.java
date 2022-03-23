package com.hu.b;
//数组的转置
public class index6_数组转置 {

	public static void main(String[] args) {
		int[][] arr=new int[4][3];
		int no=1;
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				arr[i][j]=no;
				no++;
			}
		}
		outArr(arr);
		System.out.println("\n");
		outArr(zhuanzhi(arr,4,3));
		System.out.print("\n");
	}
	
	public static void outArr(int [][] arr) { //输出数组
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	public static int[][] zhuanzhi(int[][] arr,int x,int y){ //数组转置
		int a[][]=new int[y][x];
		for(int i=0;i<y;i++) { //3
			for(int j=0;j<x;j++) {  //4
				a[i][j]=arr[j][i];
			}
		}
		return a;
	}

}
