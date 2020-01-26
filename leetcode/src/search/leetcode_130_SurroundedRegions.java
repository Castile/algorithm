package search;

/**
 * @author Hongliang Zhu
 * @create 2020-01-26 12:43
 *
 * leetcode130: 被围绕的区域
 *
 */

/*
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
示例:
X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：
X X X X
X X X X
X X X X
X O X X
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surrounded-regions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_130_SurroundedRegions {
    static  int [][]directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    // DFS 递归版本
    public static void solve(char[][] board) {
        if(board==null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        //  边缘搜索
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(( i == 0 || j == 0 || i == m-1 || j == n-1 )  &&  (board[i][j] == 'O')){
                    dfs(board, i, j);
                }
            }
        }
        //
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    public static void dfs(char[][] board, int i,  int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = '#';
        for(int[] d: directions){
            dfs(board, i+d[0], d[1]+j);
        }
    }

       // 使用并查集解决
    public static void solveUF(char[][] board) {
        if(board==null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        // 边界上的‘O’的根节点都是dummy
        UF uf = new UF(n * m + 1);//  增加一个存储dummy节点
        int dummy = m * n;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){ // 目标
                    if(i == 0 || j == 0 || i == m -1 || j == n -1) { // 如果是边界上的'O'， 与dummy合并
                        uf.union(i*n+j, dummy);
                    }else{ // 里面的
                        // 方向数组 d 是上下左右搜索的常用手法
                        int[][] d = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
                        // 将此 O 与上下左右的 O 连通
                        for (int k = 0; k < 4; k++) {
                            int x = i + d[k][0];
                            int y = j + d[k][1];
                            if (board[x][y] == 'O')
                                uf.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }

        for (int  i = 1;  i < m-1; i++){
            for( int j = 1; j < n-1; j++){
                if(!uf.isSameSet(i*n+j, dummy)){
                    board[i][j] = 'X';
                }
            }
        }


    }

    public static void main(String[] args) {

        char[][] board = {{'X','X','X','X'}, {'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        solveUF(board);

        for (char []c: board){
            System.out.println(c);
        }



    }

}
