import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer ：面试题07. 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @author Hongliang Zhu
 * @create 2020-05-30 23:27
 */
public class buildTree {

    public static void main(String[] args) {

        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
//        TreeNode head = buildTree(preorder, inorder);

        TreeNode head = reConstructBinaryTree(preorder, inorder);

        inorder(head);


    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;

        int l1 = 0;
        int r1 = preorder.length - 1;
        int l2 = 0;
        int r2 = inorder.length - 1;

        return build(preorder, inorder, l1, r1, l2, r2);

    }

    public static TreeNode build(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 > r1 || l2 > r2)
            return null;
        TreeNode node = new TreeNode(preorder[l1]);
        if (l1 == r1 || l2 == r2)
            return node;

        int index = 0;
        for (int i = l2; i <= r2; i++) {
            if (inorder[i] == preorder[l1]) {
                index = i;  // 中序遍历序列中 左子树节点的个数
                break;
            }
        }

        node.left = build(preorder, inorder, l1 + 1, l1 + index - l2, l2, index - 1);  // 左子树
        node.right = build(preorder, inorder, l1 + index - l2 + 1, r1, index + 1, r2);
//        node.right = build(preorder, inorder, r1-r2+index, r1, index + 1, r2);
        return node;

    }

    public static void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.val);
            inorder(node.right);
        }
    }


    // 优化: 使用hashmap优化查找效率

    private static Map<Integer, Integer> inorder_index = new HashMap<>();
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            inorder_index.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length-1, 0);

    }

    /**
     *
     * @param pre 前序遍历序列
     * @param l1 前序遍历的起始位置
     * @param r1 前序遍历的终止位置
     * @param l2 中序遍历的起始位置
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int l1, int r1, int l2) {
        if(l1 > r1)
            return null;

        TreeNode node = new TreeNode(pre[l1]);
        int index = inorder_index.get(node.val);
        int left_len = index - l2;
        node.left = reConstructBinaryTree(pre, l1+1, l1+left_len, l2);
        node.right = reConstructBinaryTree(pre, l1+left_len+1, r1, index+1);
        return node;

    }


}
