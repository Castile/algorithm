import java.util.ArrayList;

/**
 * @author Hongliang Zhu
 * @create 2019-12-19 17:25
 */

// 图的节点
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts; // 点
    public ArrayList<Edge> edges; // 边

    public Node(int value){
        this.value = value;
        this.in = 0;
        this.out = 0;
        nexts =new ArrayList<Node>();
        edges = new ArrayList<Edge>();

    }

    @Override
    public String toString() {
        return "value = "+value +"\nin= "+ in +"\nout = "+out+"\nnexts = " + nexts.size()+"\nedges = "+edges.size()+"\n";
    }
}
