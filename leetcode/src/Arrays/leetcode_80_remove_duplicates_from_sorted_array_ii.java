package Arrays;

/**
 * @author Hongliang Zhu
 * @create 2020-01-22 10:07
 */
public class leetcode_80_remove_duplicates_from_sorted_array_ii {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int p = 1;
        int c = 1; // 计数
        for(int i = 1; i < nums.length;  i++){
            if(nums[i] == nums[i-1]){
                c++;
            }else {
                c = 1;  //复位
            }

            if( c <= 2) {
                nums[p] = nums[i];
                p++;
            }

        }

        return p;
    }

    public static void main(String[] args) {

        int []nums = {0,0,1,1,1,1,2,3,3};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+",");
        }
        System.out.println();

    }

}
