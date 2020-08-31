package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;


/**
 * @author Hongliang Zhu
 * @create 2020-08-03 11:39
 * 单调队列
 */

class MonotonicQueue{
    private Deque<Integer> q;
    public MonotonicQueue(){
        q = new ArrayDeque<>();
    }
    private int max(){
        return q.peek();
    }

    private void push(int value){
        while(!q.isEmpty() && value > q.getLast()){
            q.pollLast();
        }
        q.offer(value);
    }

    private void pop(int value){
        if(!q.isEmpty() && q.peek() == value){
            q.pollFirst();
        }
    }

}
public class MaxSlidingWindow {

    public static void main(String[] args) {
        MonotonicQueue queue = new MonotonicQueue();


    }
}
