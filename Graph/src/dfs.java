import java.util.HashSet;
import java.util.Stack;
/**
 * @author Hongliang Zhu
 * @create 2019-12-19 19:59
 */
// 深度优先遍历
public class dfs {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        s.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!s.isEmpty()) {
            Node cur = s.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) { // 找到一个未访问的即可
                    s.push(cur); // 把当前节点进栈
                    s.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = {
                {2, 1, 3},
                {3, 1, 2},
                {5, 3, 4},
                {7, 4, 5},
                {10, 5, 2},
                {9, 5, 1},
        };

        Graph g = GraphGenerator.createGraph(matrix);
        Node node = g.nodes.get(1);
        System.out.println(node.toString());
        dfs(node);

    }


}
