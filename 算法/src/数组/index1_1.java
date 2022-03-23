package 数组;

/**
 * @author hu
 * @create 2021-12-27 14:12
 */
public class index1_1 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3};//[0 1 2 3 1 2 2 3]
        int len = removeDuplicates(nums);
        System.out.print(len+", ");
        for (int i=0;i<len;i++){
            System.out.print(i+" ");
        }
    }
    public static int removeDuplicates(int[] nums){
        int count = 0;//重复的数字个数
        for (int right =1 ; right < nums.length;right++){
            if(nums[right] == nums[right-1]){
                count++;
            }else{
                nums[right-count]=nums[right];
            }
        }
        return nums.length-count;
    }
}
