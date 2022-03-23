package com.hu.b;
//折半查找(二分查找)
public class index5_查找算法 {

	public static void main(String[] args) {
	int arr[]= new int[]{2,3,5,8,12,45,90,100};
	System.out.println(halfSearch(arr,45));
	System.out.println(xianxingSearch(arr,100));
	}
	
	//二分查找法(折半查找法)
    public static int halfSearch(int []arr,int number) {
    	int min=0;
    	int max=arr.length-1;
    	int mid=0;
    	while(min<max) {
    		mid=(min+max)/2;
    		if(number>arr[mid]) { //右边
    			min=mid+1;
    		}else if(number<arr[mid]) {  //左边
    			max=mid-1;
    		}else {
    			return mid;
    		}
    	}
    	return -1;
    }
    
    //线性查找
    public static int xianxingSearch(int arr[],int number) {
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]==number) {
    			return i;
    		}   		
    	}
    	return -1;
    }

}

