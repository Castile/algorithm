/**
 * @author Hongliang Zhu
 * @create 2019-12-19 17:41
 */
public class GraphGenerator {

    public static Graph createGraph(Integer[][] matrix){
        Graph g = new Graph();
        for(int i = 0; i< matrix.length;  i++){
            Integer weight = matrix[i][0]; // 权重
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if(!g.nodes.containsKey(from)){
                g.nodes.put(from, new Node(from));
            }if(!g.nodes.containsKey(to)){
                g.nodes.put(to, new Node(to)) ;
            }
            Node fromNode = g.nodes.get(from); // 拿出from点
            Node toNode = g.nodes.get(to);
            Edge newEdge = new Edge(weight,fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            g.edges.add(newEdge);
        }

        return g;
    }

}
