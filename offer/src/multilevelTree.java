import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *
 * @author Hongliang Zhu
 * @create 2020-06-19 0:11
 */
public class multilevelTree {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode last = root;
        TreeNode nlast = root;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.offer(root);
        List<Integer>  ans = new ArrayList<>();
        while(queue.size() > 0){
            // 出队列
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node == last){
                // 换行
                res.add(ans);
                // ans = null;
                ans.clear();
                // continue;
            }

            if(node.left != null){
                queue.offer(node.left);
                nlast = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                nlast = node.right;
            }
            last = nlast;
        }

        return res;

    }

    public static void main(String[] args) {


    }

}
