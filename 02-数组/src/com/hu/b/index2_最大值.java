package com.hu.b;
//数组最大值
public class index2_最大值 {

	public static void main(String[] args) {
		int [] arr=new int[] {1,5,8,3,9};
		System.out.println(getMax(arr));
		System.out.println(getMin(arr));
		System.out.println(Sum(arr));
		System.out.println(Avg(arr));
		
		
		//一维数组复制
		int arr1[] =new int[arr.length];
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=arr[i];
		}
		
		
		//一维数组反转
		String a[] = new String[] {"as","sd","rr","sdrf"};
		for(int i=0;i<a.length/2;i++) {
			String temp=a[i];
			a[i]=a[a.length-i-1];
			a[a.length-i-1]=temp;
		}
	}
	
	//最大值
	public static int getMax(int arr[]) {
		if(arr == null || arr.length==0) {
			System.out.println("数组不存在");
			return -1;
		}
		int max=Integer.MIN_VALUE;  //整型的最小值
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		return max;		
	}
	//最小值
	public static int getMin(int arr[]) {
		int min=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		return min;
	}
	
	//总和
	public static int Sum(int arr[]) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	//平均值
	public static float Avg(int arr[]) {
		float avg=((float)Sum(arr))/arr.length;
		return avg;
	}
	
	
}

