package LinkedList;
/**
 * @author Hongliang Zhu
 * @create 2020-02-06 17:09
 */

/*
    反转单链表： 要求时间复杂度为O((n) ，空间复杂度为O(1)；
    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
 */
public class leetcode206_ReverseLinkedList {
    // 迭代
    public static ListNode reverseList(ListNode head) {
        if(head == null)   return head;
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    // 递归版本
    public static  ListNode reverdeList_Recur(ListNode head){
       return help(head, null, head.next);
    }
    public static ListNode help(ListNode head, ListNode pre, ListNode next){
        if(head == null)    return pre;
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
        return help(head, pre, next);
    }


    // 优美递归
    public static ListNode reverseListRR(ListNode head){
        if(head == null || head.next == null)   return head;
        ListNode p = reverseListRR(head.next);
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);

        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head; //防止链表循环，需要将head.next设置为空
        head.next  = null; //每层递归函数都返回cur，也就是最后一个节点
        return p;
    }



    public static void printLinkedList(ListNode head){
        if(head == null) return;
        ListNode p = head;
        while (p != null){
            System.out.print(p.val +"\t");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(head);

        ListNode re = reverseListRR(head);

        printLinkedList(re);


    }

}
