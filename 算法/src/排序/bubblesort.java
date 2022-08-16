package 排序;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2022-04-29 14:30
 * @description：
 */
public class bubblesort {
    public static void main(String[] args) {
        int[] arr = {44,3,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(arr));
        bubblesort(arr,arr.length);
        System.out.println(Arrays.toString(arr));

    }
    //使用两次循环
    public static void bubblesort(int[] arr, int length){
        for (int i = 0; i <length-1; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }
   

}
