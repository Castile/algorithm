import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Hongliang Zhu
 * @create 2019-12-19 17:37
 */
// 图的表示
public class Graph {
    public HashMap<Integer, Node> nodes; // 点的集合
    public HashSet<Edge> edges; // 边的集合

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
