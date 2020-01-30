import java.util.*;

/**
 * @author Hongliang Zhu
 * @create 2019-12-19 20:43
 */
public class TopologicalSort {

    public static List<Node> TopologicalSort(Graph graph) {
        HashMap<Node, Integer> InMap = new HashMap<>(); // 统计当前节点的入度
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            InMap.put(node, node.in);
            if (node.in == 0) { // 如果入度为0，则进入队列
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            // 删除边
            for (Node next : cur.nexts) {
                InMap.put(next, InMap.get(next) - 1);// 修改节点的入度
                if(InMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[][] matrix = {
                {2, 1, 3},
                {3, 1, 2},
                {5, 3, 4},
                {7, 4, 5},
                {10, 5, 2},
                //{9, 5, 1},
        };

        Graph g = GraphGenerator.createGraph(matrix);
        List list = TopologicalSort(g);

    }




}
