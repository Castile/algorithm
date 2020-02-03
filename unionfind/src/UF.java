/**
 * @author Hongliang Zhu
 * @create 2020-01-25 21:25
 */
// 并查集 UF
public class UF {
    private int count = 0; // 连通分量
    private int[] parent;
    // 新增一个数组记录树的“重量”
    private int[] size;

    // 构造
    public UF(int n){ // n个元素
        this.count = n;
        size = new  int[n];
        parent = new int[n];
        // 一开始每一个节点自成一个集合，都不连通
        for (int i = 0;  i < n;  i++){
            parent[i]  = i; // 自己的父节点指向自己
            size[i] = 1; // 每隔几何只有自身一个元素
        }
    }

    public int find(int x){
        int root = parent[x];
        while (parent[root] != root){ // 路径压缩
            root = parent[root];
        }
        return root;
    }


    public boolean isSameSet(int a, int b){
        return find(a) == find(b);
    }

    public int count(){
        return count;
    }

    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB){
            return; // 同一个集合不能合并
        }else{
            if(size[rootA] > size[rootB]){
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
        }
        count--; // 连通分量个数减一
    }



}