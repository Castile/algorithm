package RecurrenceAndDynamicProgramming;
import java.util.Arrays;

/**
 * 最长递增子序列
 * @author Hongliang Zhu
 * @create 2020-04-13 17:41
 */
public class leetcode300_lengthOfLIS {
    private int[] pre;
    private int index = 0;
    private int last = 0;

    public int lengthOfLIS(int[] nums) {
        int[]dp = new int[nums.length];
        pre = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i =0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
//                    pre[i] = j;
                }
            }
        }

        // 取出最大值

        int res = 0;
        for(int i = 0; i < dp.length; i++){
            res = Math.max(res, dp[i]);
            index = i;
            last = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        leetcode300_lengthOfLIS solution = new leetcode300_lengthOfLIS();
        int len = solution.lengthOfLIS(nums);
        System.out.println("==============="+len+"=========================");
//        System.out.println(solution.last);
//        int pre = 1;
//        for(int i = 0; i < len && pre >=0; i++){
//            pre = solution.pre[solution.index];
//            int value =  nums[pre];
//            System.out.println(value);
//            pre = value;
//        }

    }


}
