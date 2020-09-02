package search;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 * @author Hongliang Zhu
 * @create 2020-08-31 16:13
 * leetcode841_visitAllRooms 钥匙和房间
 *
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode841_visitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        // 建图
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(0);
        set.add(0);
        while(!q.isEmpty()){
            if(set.size() == rooms.size()){
                return true;
            }
            int room = q.poll();
            List<Integer> next = rooms.get(room);
            if(next != null){
                for(int i = 0; i < next.size(); i++){

                    set.add(next.get(i));
                    q.offer(next.get(i));

                }
            }

        }
        return false;

    }

    public static void main(String[] args) {
        leetcode841_visitAllRooms solution = new leetcode841_visitAllRooms();
        List<List<Integer>> rooms = null;

        solution.canVisitAllRooms(rooms);
    }

}
