package com.hu.b;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.RepositoryIdHelper;

import javax.security.auth.login.Configuration;
import javax.sound.midi.Soundbank;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

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

    @Test
    public void test2(){
        //判断数组中是否存在相同的元素，如果存在输出“重复”，否者输出“不重复"
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

    @Test
    public void test3(){
        //将数组中0项去掉，将不为0的存入一个新数组
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


    @Test
    public void test4(){
        //输出 1 1 2 3 5 8 13... 斐波那契数列Fibonacci 输出20个数字
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


}
