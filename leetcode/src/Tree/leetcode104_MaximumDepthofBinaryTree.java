package Tree;

import javafx.util.Pair;

import java.util.LinkedList;

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

    TreeNode(int x) {
        val = x;
    }
}

public class leetcode104_MaximumDepthofBinaryTree {
    //    static  int i =0;
//    static  int j = 0;   // 不能在这里定义
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int i = maxDepth(root.left);
        int j = maxDepth(root.right);
        return Math.max(i, j) + 1;
    }

    /**
     * BFS 层次遍历， 记录层数，即为深度
     *
     * @param root 根节点
     * @return 二叉树的深度
     */
    public static int maxDepth_BFS(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>(); // 队列
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;// 层数加1
            // 将当前层出队列
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return maxDepth;
    }

    public static int maxDepth_DFS(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>(); // 栈
        stack.push(new Pair<>(root, 1));  // 根节点的深度为1
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> currNode = stack.pop(); // 当前节点
            maxDepth = Math.max(maxDepth, currNode.getValue()); // 与当前节点的深度比较
            // 左右子树进栈
            if (currNode.getKey().left != null) {
                stack.push(new Pair<>(currNode.getKey().left, currNode.getValue() + 1)); // 深度加1
            }
            if (currNode.getKey().right != null) {
                stack.push(new Pair<>(currNode.getKey().right, currNode.getValue() + 1));
            }

        }
        return maxDepth;

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
        System.out.println(maxDepth_BFS(root));  // 3
        System.out.println(maxDepth_DFS(root));


    }
}
