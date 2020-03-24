package array;

/**
 * @author Hongliang Zhu
 * @create 2020-01-22 17:17
 */
public class leetcode_26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] == nums[q]){
                q++;
            }else{

                nums[p+1] = nums[q];
                p++;
            }
        }

        return p + 1 ;

    }




}
