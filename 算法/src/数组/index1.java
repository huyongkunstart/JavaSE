package 数组;

/**
 * 已知有序数组，原地删除重复出现的元素，使每个元素只出现一次返回删除后数组的新长度
 * @author hu
 * @create 2021-11-02 14:56
 */
public class index1 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3};
        int len = removeDuplicates(nums);
        System.out.print(len+", ");
        for (int i=0;i<len;i++){
            System.out.print(i+" ");
        }
    }

    public static int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left =0;
        for(int right = 1; right < nums.length; right++){
            if(nums[left] != nums[right]){
//                left++;
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }



}
