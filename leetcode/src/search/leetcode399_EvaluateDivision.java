package search;
import java.util.*;

/**
 * @author Hongliang Zhu
 * @create 2020-01-31 11:21
 */
/*
给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。

示例 :
给定 a / b = 2.0, b / c = 3.0
问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]

输入为:
vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 
其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 
返回vector<double>类型。

基于上述例子，输入如下：

equations(方程式) = [ ["a", "b"], ["b", "c"] ],
values(方程式结果) = [2.0, 3.0],
queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。

 */

class Node {
    String s;
    double k;

    public Node(String s, double k) {
        this.s = s;
        this.k = k;
    }
}
public class leetcode399_EvaluateDivision {

    // dfs
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 建图
        HashMap<String,List<Node>> g = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if(!g.containsKey(a)){ // 如果图中还未包含节点a，则初始化它
                g.put(a, new ArrayList<>());
            }
            double k = values[i]; //  获取值  a / b
            g.get(a).add(new Node(b, k));  //  a -> b   : a / b = k;
            if(!g.containsKey(b)){
                g.put(b, new ArrayList<>());
            }
            g.get(b).add(new Node(a, 1.0 / k)); // b -> a : b / a = 1.0 / k
        }

        double[] ans = new double[queries.size()];  // 结果
        // 遍历queries
        for(int i = 0;  i < queries.size(); i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if(!g.containsKey(a) || !g.containsKey(b)){
                ans[i] = -1.0;
                continue;
            }
            HashSet<String> visited = new HashSet<>(); //  记录是否访问
            // 开始dfs
            double res = divide(a, b, g, visited);
            ans[i] = res;
        }
        return ans;
    }


    // dfs 除法操作， 返回 a / c
    public static double divide(String a, String c, HashMap<String,List<Node>> g, HashSet<String> visited){
        if( a == c){
            return 1.0;
        }
        visited.add(a);
        // 遍历a的邻接
        for(Node n: g.get(a)){
            String b = n.s;
            if(visited.contains(b)) continue;
            double d = divide(b, c, g, visited); //  d = b / c
             // a / c =  b /c * a / b
            if(d > 0)
                return d * n.k;  // a / b
        }
        return -1.0;
    }

    public static void main(String[] args) {
        ArrayList<List<String>> equations = new ArrayList<>();
        ArrayList<String> eq1 = new ArrayList<>();
        eq1.add("a");
        eq1.add("b");
        ArrayList<String> eq2 = new ArrayList<>();
        eq2.add("b");
        eq2.add("c");

        equations.add(eq1);
        equations.add(eq2);

        double[] values={2.0, 3.0};

        ArrayList<List<String>> queries = new ArrayList<>();
        ArrayList<String> qu1 = new ArrayList<>();
        qu1.add("a");
        qu1.add("c");
        ArrayList<String> qu2 = new ArrayList<>();
        qu2.add("b");
        qu2.add("a");

        queries.add(qu1);
        queries.add(qu2);


        Solution_DFS s = new Solution_DFS();
        double[] res = s.calcEquation(equations, values, queries);
        double[] ans = s.calcEquation_dfs(equations, values, queries);
        System.out.println(Arrays.toString(res));

        System.out.println(Arrays.toString(ans));

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));

    }
}


// AC 代码: dfs 版本
class Solution_DFS{

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>>  g = new HashMap<>(); // 图
        bulidGraph(g, equations, values);
        double[] res = new double[queries.size()]; //   结果集合

        Arrays.fill(res, -1.0); // 全部设置成-1.0；

        int index = 0;
        // 遍历问题式子
        for(List<String> q: queries){
            String a = q.get(0);
            String b = q.get(1);
            if(!g.containsKey(a) || !g.containsKey(b)){
                index++;
            }else {
                dfs(g, a, b, res, index, new HashSet<>(), 1.0);
                index++;
            }

        }
        return res;

    }

    public double[] calcEquation_dfs(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> g = new HashMap<>();
        bulidGraph(g, equations, values);
        int index = 0;
        double[] ans = new double[queries.size()];
        for (List<String> q: queries){
            String x = q.get(0);
            String y = q.get(1);
            if(!g.containsKey(x) || !g.containsKey(y)){
                ans[index] = -1.0;
                index++;
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            ans[index] = divide(x, y, g, visited);
            index++;
        }
        return ans;
    }

    // get a / b
    private double divide(String a, String b, Map<String, Map<String, Double>> g, Set<String> visitied){
        if( a == b){
            return 1.0;
        }
        visitied.add(a);
        for(String next: g.get(a).keySet()){
            if(visitied.contains(next)) continue;
            double d = divide(next, b, g, visitied); //  d = next / b
            //  a /b =  next /b * a / next
            if(d > 0)
                return d * g.get(a).get(next);
        }
        return -1.0;

    }

    private void dfs(Map<String, Map<String, Double>> g, String a, String b, double[] res, int index, Set<String> visited, double tmp){
        visited.add(a);
        if(g.get(a) == null || g.get(a).size() == 0){
            return;
        }
        if(g.get(a).containsKey(b)) {
            //  刚好存在 a->b
            res[index] = g.get(a).get(b) * tmp;
            return;
        }
        for(String next: g.get(a).keySet()){
            if(visited.contains(next))  continue;
            dfs(g, next, b, res, index, visited, g.get(a).get(next) * tmp);
        }

    }

    private void bulidGraph(Map<String, Map<String, Double>>  g , List<List<String>> equations, double[] values){
        int index = 0;
        for(List<String> e: equations){
            String a = e.get(0);
            String b = e.get(1);
            g.putIfAbsent(a, new HashMap<>());
            g.putIfAbsent(b, new HashMap<>());
            g.get(a).put(b, values[index]);   //  a -> b  : a / b
            g.get(b).put(a, 1.0 / values[index]); //  b -> a : b / a;
            index++;
            g.get(a).put(a, 1.0);
            g.get(b).put(b, 1.0);  //  自己到自己的权重为1
        }

    }


}


class Solution_UF{

    // 未完待续

//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//
//    }

}


