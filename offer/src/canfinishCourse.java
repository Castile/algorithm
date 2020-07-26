import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

/**
 *
 * leetcode 207 课程表 拓扑排序
 * @author Hongliang Zhu
 * @create 2020-07-25 21:28
 */
public class canfinishCourse {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];
        for(int[] prerequisite: prerequisites){
            List<Integer> orDefault = map.getOrDefault(prerequisite[1], new ArrayList<Integer>());
            orDefault.add(prerequisite[0]);
            map.put(prerequisite[1],  orDefault);
            degree[prerequisite[0]]++; // 入度++
        }
        int count = 0;
        Queue<Integer> q = new ArrayDeque<Integer>();
        for(int i= 0; i < numCourses; i++){
            if(degree[i] == 0){
                q.offer(degree[i]);
            }
        }
        while(!q.isEmpty()){
            int c = q.poll();
            count++; //选课加1
            for(int n: map.getOrDefault(c, new ArrayList<>())){
                degree[n]--;
                if(degree[n] == 0){
                    q.offer(n);
                }
            }

        }
        return count == numCourses;

    }

    public static void main(String[] args) {

        canfinishCourse solution = new canfinishCourse();
        int[][] courses = { {0,1}};
        boolean b = solution.canFinish(2, courses);
        System.out.println(b);
    }


}
