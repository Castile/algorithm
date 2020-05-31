
/**
 * 剑指offer
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author Hongliang Zhu
 * @create 2020-05-31 11:39
 */
public class GetNextTreeNode {

    public static TreeLinkNode getNext(TreeLinkNode node){
        if(node.right != null){
            TreeLinkNode p = node.right;
            while (p.left != null){
                p = p.left;
            }
            return p;
        }else{
            while (node.next != null){
                TreeLinkNode parent = node.next;
                if(parent.left == node){
                    return parent;
                }
                node = node.next;
            }
        }

        return null;

    }



}
