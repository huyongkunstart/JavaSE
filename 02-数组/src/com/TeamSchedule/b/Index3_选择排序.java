package com.TeamSchedule.b;

public class Index3_选择排序 {

	public static void main(String[] args) {
		int [] a=new int[] {9,1,3,6,78,90,23};
		outArr(selectsort(a));
	}
	
	
	//选择排序:直接选择排序, 堆排序
	public static int[] selectsort(int[] arr){
		for(int i=0;i<arr.length-1;i++) {
			int min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			if(i!=min) {
				int temp=arr[i];
				arr[i]=arr[min];
				arr[min]=temp;
			}
		}
		return arr;
	}
	
	//交换排序：冒泡排序，快速排序
	
	//冒泡排序
	public static int[] bubblesort(int [] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j+1]<arr[j]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	
	//快速排序
	/**
	 * 快速排序
	 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
	 * 则分别对这两部分继续进行排序，直到整个序列有序。
*/
	
	//插入排序：直接插入排序，折半插入排序，shell排序
	
	//归并排序
	
	//桶式排序
	
	//基数排序
	
	
	public static void outArr(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
