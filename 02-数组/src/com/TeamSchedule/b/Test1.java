package com.TeamSchedule.b;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2022-03-21 22:14
 * @description：
 */
public class Test1 {
    public static void main(String[] args) {

        //设置保留小数点位数
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数
        System.out.println(df.format((float) 5 / 2));
    }
    //一维数组小练习，求电话号码
    @Test
    public void test0(){
        int[] arr = new int[] {3,9,1,5,0,6};
        String tel="";
        int[] index=new int[] {2,3,3,0,1,5,1,1,4,4,2};
        for(int i=0;i<index.length;i++) {
            tel+=arr[index[i]];
        }
        System.out.println(tel);
    }
    @Test
    public void test01(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入学生人数:");
        int n = scanner.nextInt();
        float gray[] = new float[n];
        float max=Float.MIN_VALUE;
        System.out.println("请输入"+n+"个学生成绩：");
        for (int i = 0; i < gray.length; i++) {
            gray[i] = scanner.nextFloat();
            if(gray[i]>max) {
                max=gray[i];
            }
        }
        System.out.println("最高分为:"+max);
        for(int i=0;i<gray.length;i++) {
            if(gray[i]>=max-10) {
                System.out.println("Student "+i+" score is "+gray[i]+" grade is A");
            }else if(gray[i]>=max-20) {
                System.out.println("Student "+i+" score is "+gray[i]+" grade is B");
            }else if(gray[i]>=max-30) {
                System.out.println("Student "+i+" score is "+gray[i]+" grade is C");
            }else {
                System.out.println("Student "+i+" score is "+gray[i]+" grade is D");
            }
        }
    }

    @Test
    public void test1(){
        //将十进制35转化为二进制，用数组存取
        int[] arr = new int[20];
        int a =35;
        int i = 0;
        do {
            arr[i++] = a%2;
            a = a/2;
        }while (a != 0);

        int[] arr1 = new int[i];
        for (int j = 0; j < i; j++) {
            arr1[j] = arr[i-j-1];
        }
        System.out.println(Arrays.toString(arr1));
    }

    //判断数组中是否存在相同的元素，如果存在输出“重复”，否者输出“不重复"
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,0};
        Label:for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("重复");
                    break Label;
                }
                if (i == arr.length-2 && j == arr.length-1){
                    System.out.println("不重复");
                }
            }
        }

        //方式二
       /* int[] arr = new int[]{1,2,3,4,1};
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                System.out.println("重复");
                break;
            }
        }

        if (flag){
            System.out.println("不重复");
        }*/


    }

    //将数组中0项去掉，将不为0的存入一个新数组
    @Test
    public void test3(){
        int[] arr = {12,4,0,4,5,0,4,33,89,0};
        int sum = 0;
        for (int j : arr) {
            if (j == 0) {
                sum += 1;
            }
        }
        //创建新数组
        int[] arr1 = new int[arr.length - sum];

        int n =0;
        for (int j : arr) {
            if (j != 0) {
                arr1[n++] = j;
            }
        }
        System.out.println(Arrays.toString(arr1));
    }


    //输出 1 1 2 3 5 8 13... 斐波那契数列Fibonacci 输出20个数字
    @Test
    public void test4(){
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test5(){
        //冒泡排序
        int[] arr = new int[]{12,3,56,3,89,50,32,14,1,5};
        int swap;
        int num = 0;
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = false;
            for (int j = 1; j <arr.length-i ; j++) {
                num++;
                if(arr[j]<arr[j-1]){
                    swap = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = swap;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
        System.out.println(num);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test6(){
        //选择排序
        int[] arr = new int[]{12,3,56,3,89,50,32,14,1,5};
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test7(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入查找的值:");
        int m = scan.nextInt();
        //二分查找
        int[] arr = {12,34,56,77,99,100};
    }
    public int search(int[] arr,int m){
        int left = 0;
        int right = arr.length-1;

        while (left <= right){
            int middle = (left+right) >>> 1;
            if (arr[middle] > m){
                right = middle-1;
            }else if(arr[middle] < m){
                left = middle+1;
            }else {
                return middle;
            }
        }
        return -(left+1);
    }

    //创建一个长度为6的int型数组，要求数组元素的值都在1-30之间，且是随机赋值，
    //同时要求元素的值各不相同
    @Test
    public void test8(){
        /*
		 * int arr[] =new int[6];
		 * for(int i=0;i<arr.length;i++) {
		 * arr[i]=(int)(Math.random()*30)+1;
		 * boolean flag=true;
		 * while(true) {
			 for(int j=0;j<i;j++) {
			 		if(arr[i] == arr[j]) {
			 		flag=true; break;
			  		}
			 }
		 	 if(flag) {
		 		arr[i]=(int)(Math.random()*30)+1;
		 		flag=false; continue;
		 	 }
		  	 break;
		  }
		 * }
		 */

        //方法二
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 30) + 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }


    //回形数
    @Test
    public void test9(){
            String s1 = new String("学习Java的小姐姐");
            s1.intern();
            String s2 = "学习Java的小姐姐";
            System.out.println(s1 == s2); //false

            String s3 = new String("学习Java的小姐姐") + new String("test");
            s3.intern();
            String s4 = "学习Java的小姐姐test";
            System.out.println(s3 == s4); //true
    }



}
