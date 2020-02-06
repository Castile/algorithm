/**
 * @author Hongliang Zhu
 * @create 2020-02-06 22:38
 */
/*

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class leetcode104_MaximumDepthofBinaryTree {
//    static  int i =0;
//    static  int j = 0;   // 不能在这里定义
    public static int maxDepth(TreeNode root) {
        if(root == null)    return 0;
        int i = maxDepth(root.left);
        int j = maxDepth(root.right);
        return Math.max(i, j)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t2.right = t5;

        System.out.println(maxDepth(root));  // 3


    }
}
