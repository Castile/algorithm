/**
 * @author Hongliang Zhu
 * @create 2019-12-15 19:12
 */

/**
 * 岛问题
 *  *
 *  * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
 *  * 四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
 *  * 矩阵中有多少个岛？
 *  * 举例：
 * 	0 0 1 0 1 0
 * 	1 1 1 0 1 0
 * 	1 0 0 1 0 0
 * 	0 0 0 0 0 0
 * 	这个矩阵中有三个岛。
 */
public class isLand {

    public static int CountIsIland(int [][]grid){

        if(grid == null || grid[0] == null){
            return 0;
        }
        int R = grid.length; //行
        int C = grid[0].length; // 列
        int cnt = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 1){
                    cnt++; // 岛屿的个数加一
                    infect(grid, i, j, R, C); // 感染函数
                }
            }
        }


    return cnt;
    }

    /**
     * 感染函数： 将i， j位置的上下左右位置进行检查，是否为同一个岛屿
     * @param m： 岛屿矩阵
     * @param i： 下标
     * @param j：  下标
     * @param R: 行
     * @param C： 列
     */
    public  static void infect(int[][] m, int i, int j, int R, int C){
        if(i < 0 || i >= R || j < 0 || j >= C || m[i][j] != 1)
            return;
        m[i][j] = 2;
        // 依次感染上下左右位置
        infect(m, i+1, j, R, C);
        infect(m, i-1, j, R, C);
        infect(m, i, j-1, R, C);
        infect(m, i, j+1, R, C);

    }

    //当矩阵的规模特备巨大的时候，将岛屿分块计算， 然后使用并查集结构合并相连的岛屿：多核计算

    public static void main(String[] args) {

        int[][] m = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };



        System.out.println(CountIsIland(m));

    }


}
