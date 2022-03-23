package 数组;

import java.util.Arrays;

/**
 * 两数之和
 * @author hu
 * @create 2021-11-02 15:37
 */
public class index2 {
    public static void main(String[] args) {
        int[] nums = {2,11,7,15};
        int target=9;
        System.out.println(Arrays.toString(twoSum(nums,target)));;
    }
    public static int[] twoSum(int[] nums, int target){
        int a = 0,b =0;
        for (int i=0;i<nums.length;i++){
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

}
