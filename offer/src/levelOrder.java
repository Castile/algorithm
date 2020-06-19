import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 面试题32 - I. 从上到下打印二叉树
 *
 * 二叉树的层次遍历
 *
 * @author Hongliang Zhu
 * @create 2020-06-18 23:32
 */
public class levelOrder {

    public static void main(String[] args) {

    }

    public static int[] levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while(queue.size() > 0){
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }

//        Integer[] integers = ans.toArray(new Integer[]{});
//
//        return integers;

        int[] ints = ans.stream().mapToInt(Integer::valueOf).toArray();

        ans.clear();
        return ints;


    }

}
