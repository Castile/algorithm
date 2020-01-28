import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Hongliang Zhu
 * @create 2020-01-28 21:28
 */
/*
leetcode990: Satisfiability of Equality Equations  等式的合法判定
tips： 并查集
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一：
"a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：

输出：["b==a","a==b"]
输入：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：

输入：["a==b","b==c","a==c"]
输出：true
示例 4：

输入：["a==b","b!=c","c==a"]
输出：false
示例 5：

输入：["c==c","b==d","x!=z"]
输出：true
 */
public class leetcode990_SatisfiabilityOfEqualityEquations {

    // 并查集
    public static boolean equationsPossible(String[] equations) {
        UF uf = new UF(26); // 26个字母
        // 所有等式连通
        for (String eq : equations) {
            if (eq.charAt(1) == '=') { // 判断为等式
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        // 判断不等式会不会破坏连通性
        for (String eq : equations) {
            if (eq.charAt(1) == '!') { // 判断为不等式
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.isSameSet(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;

    }

    //连通 染色
    public static boolean equationsPossible_DFS(String[] equations) {
        ArrayList<Integer>[] graph = new ArrayList[26]; // 26个字母
        // 初始化
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        // 等式进行连通
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                graph[x - 'a'].add(y - 'a');
                graph[y - 'a'].add(x - 'a');
            }
        }

        int[] color = new int[26]; // 准备26种颜色
        int t = 0;
        for (int i = 0; i < 26; i++) {
            if (color[i] == 0) { // 第i个字母还没染色
                t++; // 增加一种颜色
                Stack<Integer> s = new Stack<Integer>();
                s.push(i);
                while (!s.isEmpty()) {
                    int node = s.pop();
                    for (int nn : graph[node]) {// 取出与node连通的所有点， 即取出等式两边的字母
                        if (color[nn] == 0) {
                            color[nn] = t; // 连通的节点设置成相同的颜色
                            s.push(nn); //  将与之连通的节点进栈，实现等式传递性的功能
                        }
                    }

                }

            }
        }
        // 检查不等式的合法性
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                if (x == y || color[x] != 0 && color[x] == color[y]) { // 字母相等，颜色相同的一定不满足不等关系
                    return false;
                }
            }
        }
        return true;

    }


    public static void main(String[] args) {
        String[] equations1 = {"c==c", "b==d", "x!=z"};
        System.out.println(equationsPossible(equations1));
        String[] equations2 = {"a==b", "b==c", "a==c"};
        System.out.println(equationsPossible(equations2));
        String[] equations3 = {"b==a", "a!=b"};
        System.out.println(equationsPossible(equations3));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(equationsPossible_DFS(equations1));
        System.out.println(equationsPossible_DFS(equations2));
        System.out.println(equationsPossible_DFS(equations3));

    }


}
