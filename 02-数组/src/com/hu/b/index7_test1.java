package com.hu.b;
/**
 * 
 * @Description 一维数组小练习，求电话号码
 * @author hu Email:huyongkun2000@163.com
 * @version
 * @date 2021年1月20日上午10:07:12
 */
public class index7_test1 {
	public static void main(String [] args) {
		int[] arr = new int[] {3,9,1,5,0,6};
		String tel="";
		int[] index=new int[] {2,3,3,0,1,5,1,1,4,4,2};
		for(int i=0;i<index.length;i++) {
			tel+=arr[index[i]];
		}
		System.out.println(tel);
	}
}
