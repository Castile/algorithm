package Arrays;
import java.util.HashMap;

/**
 * @author Hongliang Zhu
 * @create 2020-01-23 21:39
 */
public class leetcode_1_twoSum {

    // 暴力法
    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    break;
                }
            }
        }

        return a;
    }

    // 哈希
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> mymap = new HashMap<>();
        for(int i = 0; i < nums.length;  i++){
            mymap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int t = target - nums[i];
            if(mymap.containsKey(t) && mymap.get(t) != i ){
                return new int[] {i,mymap.get(t)};
            }
        }

        return null;

    }


    public static void main(String[] args) {
       int[] nums = { 2,11,15, 7};
       int target = 9;
       int []result = twoSum1(nums, target);


       for (int i = 0;  i < result.length; i++)
       {
           System.out.println(result[i]);
       }

    }


}
