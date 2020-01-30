/**
 * @author Hongliang Zhu
 * @create 2019-12-19 17:27
 */
// 边
public class Edge {
    public int weight;// 权重
    public Node from; //
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;

    }

}
