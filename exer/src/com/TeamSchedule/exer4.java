package com.TeamSchedule;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2022-05-10 12:24
 * @description： 冒泡排序  选择排序   二分查找  懒汉式 和 饿汉式
 */
public class exer4 {
    public static void main(String[] args) {
        int[] arr = {2,5,67,1,34,90,33,77,0,22,34,67,45};
        test1(arr);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序
    public static void test1(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j+1] < arr[j]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }


    //选择排序
    @Test
    public void test2(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }

    //二分查找
    @Test
    public int test3(int[] arr, int m){
        int left = 0;
        int right = arr.length-1;
        while (right >= left){
            int middle = (left + right)/2;
            if(arr[middle] > m){
                right = middle -1;
            }else if (arr[middle] < m){
                left = middle +1;
            }else {
                return middle;
            }
        }
        return -1;
    }

}

//饿汉式
class Bank{
    private Bank(){};
    private static Bank bank = new Bank();
    public static Bank getInstance(){
        return bank;
    }
}



//懒汉式
class Window{
    private Window(){};
    private static Window window = null;

    public static Window getInstance(){
        if(window == null){
            synchronized (Window.class){
                if(window == null){
                    window = new Window();
                }
            }
        }
        return window;
    }
}