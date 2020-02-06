package RecurrenceAndDynamicProgramming;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-02-06 15:27
 */
/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 3
输出: [1,3,3,1]
 */
public class leetcode119_PascalTriangle2 {
    // 方法一： 空间复杂略高
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++){
            cur = new ArrayList<>();
            for(int j = 0; j <= i ; j++){
                if(j == 0 || i == j){
                    cur.add(1);
                }else{
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return cur;
    }


    public List<Integer> getRow1(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for(int i = 1; i <= rowIndex; i++){
            for(int j = 1; j < i; j++){
                int tmp = cur.get(j);
                cur.set(j, pre + cur.get(j));
                pre = tmp;
            }
            cur.add(1);
        }
        return cur;
    }


    // 倒着进行
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i - 1; j > 0; j--){
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);
        }
        return cur;
    }


}
