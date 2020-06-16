import java.util.*;

/**
 * 剑指offer： 面试题06. 从尾到头打印链表
 * @author Hongliang Zhu
 * @create 2020-05-29 23:52
 */

public class reversePrint {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        int[] ints = reversePrint1(head);
        for(int i: ints){
            System.out.println(i);
        }


    }

    public static int[] reversePrint1(ListNode head){
        Deque<Integer> stack = new ArrayDeque<Integer>();
        if(head == null)    return null;
        ListNode ll = head;
        while (ll != null){
            stack.addFirst(ll.val);
            ll = ll.next;
        }
        System.out.println(stack);
        Integer []res = new Integer[stack.size()];

        Integer[] integers = stack.toArray(res);

        int[] ret = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();

//        System.out.println(integers);
        return ret;


    }


    //递归
    public static List<Integer> reversePrint2(ListNode head){
        ArrayList<Integer> list = new ArrayList<>();
        if(head !=  null){
            list.addAll(reversePrint2(head.next));
            list.add(head.val);
        }
        return list;
    }






}
