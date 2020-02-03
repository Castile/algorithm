/**
 * @author Hongliang Zhu
 * @create 2019-12-15 18:50
 */

import java.util.HashMap;
import java.util.List;

/**
 * 并查集结构
 */

class Node{
    // whatever you like , String, int, char。。。
}

public class UnionFindSet {

    public HashMap<Node, Node> fatherMap; // key:child, value: father
    public HashMap<Node, Integer> sizeMap; // 某个节点所在的集合一共有多少个节点 Integer

    public UnionFindSet(){
        // 初始化
        fatherMap = new HashMap<Node, Node>();
        sizeMap = new HashMap<Node, Integer>();
    }

    private void makeStes(List<Node> nodes){
        fatherMap.clear();
        sizeMap.clear();
        for (Node node: nodes){
            fatherMap.put(node, node); // 开始时每个元素自成一个集合，其父节点指向自己
            sizeMap.put(node, 1); // 开始时每个集合的元素只有1个
        }
    }

    // 查找元素的根节点
    private Node findRoot(Node node){
        Node root = fatherMap.get(node);
        if(root != node){
            root = findRoot(root); // 一直向上寻找根节点
        }
        fatherMap.put(node, root); // 修改父节点  // 路径压缩
        return root;
    }

    // 判断两个元素是否在一个集合中
    public boolean isSameSet(Node a, Node b){
        return findRoot(a) == findRoot(b);

    }

    public void union(Node a, Node b){
        if(a == null || b == null){
            return;
        }
        Node aRoot = findRoot(a);
        Node bRoot = findRoot(b);
        if(aRoot != bRoot){
            int aRank = sizeMap.get(a);
            int bRank = sizeMap.get(b);
            if( aRank <= bRank){ // a的节点数少， 将a挂在b中
                fatherMap.put(aRoot, bRoot);
                sizeMap.put(bRoot, aRank+bRank); // 更新b得根节点的树的节点数
            }else {
                fatherMap.put(bRoot, aRoot);
                sizeMap.put(aRoot, aRank+bRank);
            }
        }

    }





}
