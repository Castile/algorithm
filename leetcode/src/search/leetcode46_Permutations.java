package search;

/**
 * @author Hongliang Zhu
 * @create 2020-04-30 19:39
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.util.*;

/**
 * backtracking 回溯法
 */
public class leetcode46_Permutations {

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void dfs(int[] nums, int pos, LinkedList<Integer> list, List<List<Integer>> result){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos; i < nums.length; i++){
            list.addLast(nums[i]);
            swap(nums, pos, i);
            dfs(nums, pos+1, list, result);
            swap(nums, pos, i);
            list.removeLast();

        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums, 0, list, result);
        return result;
    }

       public static void main(String[] args) {
           Solution solution = new Solution();
//        leetcode46_Permutations solution = new leetcode46_Permutations();

        int[] nums = {1,2,3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }

}

class Solution{

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        Deque<Integer> list = new ArrayDeque<>();
        dfs(nums, len, 0, list, result, visited);
        return result;

    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> list, List<List<Integer>> result, boolean[] visited) {
        if(depth == len){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!visited[i]){
                visited[i] = true;
                list.addLast(nums[i]);
                dfs(nums, len,depth+1, list, result, visited);
                visited[i] = false;
                list.removeLast();
            }

        }
    }


}
