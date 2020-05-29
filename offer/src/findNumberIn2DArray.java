
/**
 * 剑指offer 面试题04. 二维数组中的查找
 *
 * @author Hongliang Zhu
 * @create 2020-05-29 22:59
 */
public class findNumberIn2DArray {

    public static void main(String[] args) {

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        Solution solution = new Solution();
        boolean flag = solution.findNumberIn2DArray(matrix, 20);
        System.out.println(flag);
    }


}

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) return false;
        int i = matrix[0].length - 1; // 列
        int j = 0; // 行
        while (i >= 0 && j < matrix.length) {
            if (matrix[j][i] == target) {
                return true;
            } else if (matrix[j][i] > target) {
                i--;
            } else {
                j++;
            }
        }

        return false;

    }
}
