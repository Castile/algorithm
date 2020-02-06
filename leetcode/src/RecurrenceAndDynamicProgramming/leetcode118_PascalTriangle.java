package RecurrenceAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-02-06 10:54
 */
/*
 杨辉三角：
 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
public class leetcode118_PascalTriangle {

    // 暴力递归： 但是会超时
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) return triangle;
        for(int i = 1 ; i <= numRows; i++){
            List<Integer> list =  new ArrayList<>();
            for(int j = 1; j <= i ; j++){
                list.add(calc(i, j));
            }
            triangle.add(list);
        }
        return triangle;
    }
    public int calc(int i, int j){
        if( j == 1 || i == j)   return 1;
        return calc(i - 1, j - 1) + calc(i - 1, j);
    }

    // 动态规划
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<>();
            int[][] dp = new int[numRows+1][numRows+1];
            if(numRows == 0) return triangle;
            for(int i = 1 ; i <= numRows; i++){
                List<Integer> list =  new ArrayList<>();
                for(int j = 1; j <= i ; j++){
                    list.add(calc(dp, i, j));
                }
                triangle.add(list);
            }
            return triangle;
        }
        public int calc(int[][] dp, int i, int j){
            if( j == 1 || i == j){
                dp[i][j] = 1;
                return 1;
            }
            if(dp[i][j] != 0)   return dp[i][j];
            dp[i][j] = calc(dp, i - 1, j - 1) + calc(dp, i - 1, j);
            return dp[i][j];
        }
    }
}
