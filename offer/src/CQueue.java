
import java.util.LinkedList;

/**
 * 剑指offer ： 面试题09. 用两个栈实现队列
 *
 * @author Hongliang Zhu
 * @create 2020-05-31 11:59
 */
public class CQueue {

    private LinkedList<Integer> s1;// 栈1
    private LinkedList<Integer> s2;// 栈2
    private int size;

    public CQueue() {
         s1 = new LinkedList<>();
         s2 = new LinkedList<>();
         size = 0;

    }

    public void appendTail(int value) {
        s1.push(value);
        size++;
    }

    public int deleteHead() {
        if(size == 0){
            return -1;
        }
//        while (!s1.isEmpty()){
//            s2.push(s1.pop());
//        }
//        int ret = s2.pop();
//        //返回s1中
//        while (!s2.isEmpty()){
//            s1.push(s2.pop());
//        }
//        return ret;

        // 优化，只有当s2中元素为空的时候，才把s1中的元素倒进来
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }

        }
        size--;
        return s2.pop();

    }

}
