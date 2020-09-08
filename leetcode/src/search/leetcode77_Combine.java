package search;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-09-08 9:51
 * leetcode77-组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class leetcode77_Combine {

    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list);


//        dfs(n, k, 1, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int n, int k, int  pos, List<Integer> ans){
        if(pos > n+1){
            return;
        }
        if(ans.size() == k){
            res.add(new ArrayList(ans));
//            return;
        }

        for(int i =pos; i <= n; i++){
            ans.add(i);
            dfs(n, k, i+1, ans);
            ans.remove(ans.size()-1);
        }
    }

    public static void main(String[] args) {
        leetcode77_Combine solution = new leetcode77_Combine();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }
}
