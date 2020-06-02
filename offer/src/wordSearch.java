/**
 * 剑指offer  字符搜索 面试题12. 矩阵中的路径
 * @author Hongliang Zhu
 * @create 2020-06-02 20:46
 */
public class wordSearch {

    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0 || board[0].length == 0)  return false;

        int m = board.length; //行
        int n = board[0].length; // 列
        boolean[] visited = new boolean[m*n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != word.charAt(0)){
                    continue;
                }

                // boolean[] visited = new boolean[m*n];  //因为每个位置都可以开始。所以这个数组应该每一次都初始化一次
                visited[i * n + j] = true;
                // 第一个字符已经匹配到了
                if(dfs(board, 1, visited, i, j, m, n, word)){
                    return true;
                }

            }
        }

        return false;

    }

    // 定义四个方向
    int [][]d = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public boolean dfs(char[][] board, int pos,  boolean visited[], int i, int j, int m, int n, String word){
        if(pos == word.length())  return true;

        for(int p = 0; p < 4; p++){
            int ii = i + d[p][0];
            int jj = j + d[p][1];
            if( ii < 0 || ii >= m || jj < 0 || jj >= n || board[ii][jj] != word.charAt(pos) || visited[ii*n + jj]){
                continue;
            }
            visited[ii *n + jj] =  true;
            if(dfs(board, pos+1, visited, ii, jj, m, n, word)){
                return true;
            }
            visited[ii *n + jj] = false ; // 回溯
        }

        visited[i * n +j]  = false;

        return false;

    }


}


class findPath {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || "".equals(word))    return false;

        int rows= board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, 0, i, j, rows, cols, visited, word)){
                        return true;
                    }
                }
            }
        }

        return false;


    }

    private boolean dfs(char[][] matrix, int pos, int i, int j, int rows, int cols, boolean[][] visited, String str){
        if( pos == str.length())    return true;
        if( i < 0 || i >= rows  || j < 0 || j >= cols || visited[i][j] || matrix[i][j] != str.charAt(pos)){
            return false;
        }

        visited[i][j] = true;
        boolean flag = dfs(matrix, pos+1, i - 1, j, rows, cols, visited, str) || dfs(matrix, pos+1, i + 1, j, rows, cols, visited, str)|| dfs(matrix, pos+1, i, j-1, rows, cols, visited, str) || dfs(matrix, pos+1, i, j+1, rows, cols, visited, str);

        visited[i][j] = false;

        return flag;

    }


}
