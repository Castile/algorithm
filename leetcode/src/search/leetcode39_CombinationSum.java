package search;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Hongliang Zhu
 * @create 2020-09-09 15:19
 *
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * </em>candidates 中的数字可以无限制重复被选取。</em>
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 */
public class leetcode39_CombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int sum, int pos, List<Integer> ans) {

        if(sum  == target){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(sum > target){
            return;
        }

        for(int i = pos; i < candidates.length; i++){
            ans.add(candidates[i]);
            backtrack(candidates, target, sum+candidates[i], i , ans);
            ans.remove(ans.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        leetcode39_CombinationSum solution = new leetcode39_CombinationSum();
        List<List<Integer>> lists = solution.combinationSum(candidates, 8);
        System.out.println(lists);
    }
}
