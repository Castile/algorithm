package search;
/**
 * @author Hongliang Zhu
 * @create 2020-02-02 17:04
 */

/*
Leetcode 696 岛屿的最大面积
给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。

示例 2:
[[0,0,0,0,0,0,0,0]]
对于上面这个给定的矩阵, 返回 0。
注意: 给定的矩阵grid 的长度和宽度都不超过 50。

 */

public class leetcode_695_MaxAreaIsland {
    int m;
    int n;
    int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                result = Math.max(result, dfs(grid, i, j));
            }
        }
        return result;
    }
//    int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int dfs(int[][] grid, int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0){
            return 0;
        }
        grid[x][y] = 0;
        int c = 1; // 面积加1
        for(int k = 0; k < 4; k++){
            int i = x + d[k][0];
            int j = y + d[k][1];
            c += dfs(grid, i, j);  // 搜索上下左右
        }
        // for(int[] dd: d){
        //     c += dfs(grid, x + dd[0], y + dd[1]);
        // }
        return c;
    }

}

