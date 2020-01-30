package search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hongliang Zhu
 * @create 2020-01-29 20:57
 */

/*
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，
那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
你必须输出所有学生中的已知的朋友圈总数。

示例 1:

输入:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。
示例 2:

输入:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出: 1
说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
注意：

N 在[1,200]的范围内。
对于所有学生，有M[i][i] = 1。
如果有M[i][j] = 1，则有M[j][i] = 1。
 */
public class leetcode547_FriendCircles {

    // 深度优先
    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) { // 是连通的并且还未访问
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public static int findCircleNum_DFS(int[][] M) {
        int count = 0;
        int n = M.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;  // 执行一次dfs表示增加了一个连通块
            }
        }
        return count;
    }


    /*
        下面使用并查集
     */
     static int []parents;
     static int []size;
     static int count1 = 0; //  连通分量
     public static void makeSet(int n){
         parents = new int[n];
         size = new int[n];
         count1 = n;
         for(int i = 0;  i < n; i++){
             size[i] = 1;
             parents[i] = i;
         }

     }
     public static int find(int a){
         int root = parents[a];
         while(root!= parents[root]){
             root = parents[root];
         }
         return root;
     }
     public static void union(int a, int b){
         int roota = find(a);
         int rootb = find(b);
         if(roota != rootb){
             if(size[roota] > size[rootb]){
                 parents[rootb] = roota;
                 size[roota] = size[roota]+size[rootb];
             }else{
                 parents[roota] = rootb;
                 size[rootb] = size[roota]+size[rootb];
             }
             count1--;
         }
     }

    public static int findCircleNum(int[][] M) {

        int n = M.length;
        makeSet(n);
        for(int i = 0;  i< n; i++){
             for( int j = i+1; j < n; j++){
                 if(M[i][j] == 1)// 朋友
                 {
                     union(i, j);
                 }
             }
        }

        return count1;
    }



    // 广度优先遍历
    public static int findCircleNum_BFS(int[][] M) {
        int n = M.length;
        int count = 0;
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                queue.add(i);
                while (!queue.isEmpty()){
                    int k = queue.remove();
                    visited[k] = 1;
                    for(int j = 0; j < n; j++){
                        if(M[k][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }

        return count;

     }






    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(findCircleNum_DFS(M));
        System.out.println(findCircleNum_BFS(M));
        System.out.println(findCircleNum(M));


    }


}
