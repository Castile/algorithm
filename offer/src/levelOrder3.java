import java.util.*;

/**
 *
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 *
 * 之字形打印二叉树
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *
 * @author Hongliang Zhu
 * @create 2020-06-19 23:15
 */
public class levelOrder3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        boolean flag = true;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> ans = new ArrayList<>();
            Deque<TreeNode> s = new ArrayDeque<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                ans.add(node.val);
                TreeNode n = stack.pop();
                if(flag){
                    if(n.right != null){
                        s.push(n.right);
                        queue.offer(n.right);
                    }
                    if(n.left != null){
                        s.push(n.left);
                        queue.offer(n.left);
                    }

                }else{
                    if(n.left != null){
                        s.push(n.left);
                        queue.offer(n.left);
                    }
                    if(n.right != null){
                        s.push(n.right);
                        queue.offer(n.right);
                    }

                }


            }
            stack = s;
            flag = !flag;
            res.add(ans);
        }

        return res;

    }

}
