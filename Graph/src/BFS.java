import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hongliang Zhu
 * @create 2019-12-19 18:54
 */


// 广度优先遍历
public class BFS {

    public static void BFS(Node node){
        if(node == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        q.add(node);
        set.add(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            System.out.println(cur.value);
           for(Node next: cur.nexts){
               if(!set.contains(next)){
                   set.add(next);
                   q.add(next);
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
        BFS(node);


    }



}
