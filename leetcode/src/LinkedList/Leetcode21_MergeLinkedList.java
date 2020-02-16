package LinkedList;

/**
 *
 * @author Hongliang Zhu
 * @create 2020-02-16 12:36
 */

/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class Leetcode21_MergeLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        l1.next = n1;
        n1.next = n3;

        ListNode l2 = new ListNode(1);
        ListNode m1 = new ListNode(3);
        ListNode m2 = new ListNode(4);
        l2.next = m1;
        m1.next = m2;

        Solution s = new Solution();
        ListNode  res = s.mergeTwoLists_Cur(l1, l2);

        while (res != null) {
            System.out.print(res.val +"     ");
            res = res.next;
        }
        System.out.println();

    }




}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy= new ListNode(-1);
        ListNode list = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null && p2 != null){
            if(p1.val > p2.val){
                list.next = p2;
                p2 = p2.next;

            }else
            {
                list.next = p1;
                p1 =  p1.next;
            }
            list = list.next;
        }
        //处理p1
        if(p1 != null){
            list.next = p1;
        }
        if(p2 != null){
            list.next = p2;
        }

        return dummy.next;


    }

    // 递归
    public ListNode mergeTwoLists_Cur(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        if(l1.val > l2.val){
            l2.next = mergeTwoLists_Cur(l1, l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists_Cur(l1.next, l2);
            return l1;
        }
    }



}


/**
 *
 *
 * s输出：
 * 1     1     2     3     4     4
 */
