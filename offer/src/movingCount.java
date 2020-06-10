/**
 *
 *
 * 面试题13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Hongliang Zhu
 * @create 2020-06-10 19:40
 */
public class movingCount {


    public static void main(String[] args) {
        int m = 16;
        int n = 16;
        int k = 1;

        int[][] visited = new int[m][n];

        int count = dfs( 0, 0, m, n, k, visited);

        System.out.println(count);


    }

    static int[][] dd = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static int dfs(int i, int j, int m, int n, int k, int[][]visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1 || getSum(i) + getSum(j) > k) {
            return 0;
        }

        visited[i][j] = 1;

        //上下左右
        int cc = 0;
        for (int d = 0; d < 4; d++) {
            int ii = i + dd[d][0];
            int jj = j + dd[d][1];
            cc += dfs(ii, jj, m, n, k, visited);
        }

        return cc+1;


    }

    public static int getSum(int n){
        int s = 0;
        while(n != 0){
            int g = n % 10;
            s+=g;
            n = n /10;
        }
        return s;
    }

}
