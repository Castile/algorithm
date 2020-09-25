package Tree;

/**
 * @author Hongliang Zhu
 * @create 2020-09-25 10:03
 *
 * leetcode 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 */
public class BuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        reverse(postorder);
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length-1);

    }

    private void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while( i < j ){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private TreeNode helper(int[] inorder, int[] revPost, int l1, int r1, int l2, int r2){
        if( l1 > r1|| l2 > r2){
            return null;
        }
        TreeNode root = new TreeNode(revPost[l2]);
        if( l1 == r1|| l2 == r2){
            return root;
        }
        int index = 0;
        for(int i = l1; i <= r1; i++){
            if(inorder[i] == revPost[l2]){
                index = i;
                break;
            }
        }

        root.right = helper(inorder, revPost, index+ 1, r1, l2+1, l2 + (r1-index) );
        root.left = helper(inorder, revPost, l1, index -1 , l2 + (r1-index) + 1, r2);
        return root;

    }

    public static void main(String[] args) {

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(inorder, postorder);



    }



}
