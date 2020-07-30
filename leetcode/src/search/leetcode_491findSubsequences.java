package search;
import java.util.*;

/**
 * @author Hongliang Zhu
 * @create 2020-07-30 9:37
 *
 *
 *leetcode-491： 递增子序列
 *
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class leetcode_491findSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<Integer>(), 0);
        return res;

    }

    private void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> ans, int pos){
        if(ans.size() >= 2){
            res.add(new ArrayList<>(ans));
        }
        if(pos == nums.length){
            return;
        }

        Set<Integer> set  = new HashSet<>();
        ///ans.add(nums[pos]);
        for(int i = pos; i < nums.length; i++){
            if(set.contains(nums[i]) )  continue;
            if(ans.size() == 0 || nums[i] >= ans.get(ans.size()-1) ){

                ans.add(nums[i]);
                set.add(nums[i]);
                dfs(nums, res, ans, i+1);
                ans.remove(ans.size()-1);

            }
        }


    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        leetcode_491findSubsequences solution = new leetcode_491findSubsequences();
        List<List<Integer>> subsequences = solution.findSubsequences(nums);
        for(List<Integer> ans: subsequences){
            System.out.println(ans);
        }


    }
}
