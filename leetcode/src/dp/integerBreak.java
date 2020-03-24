/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        if(n <= 3)  return n - 1;
        int x = n / 3;
        int y = n % 3;
        if(y == 0){
            // 余数为0，说明刚好是3的倍数
            return (int)(Math.pow(3, x));
        }else if( y == 1){
            return (int)(Math.pow(3, x - 1) * 2 * 2);
        }else{
            return (int)(Math.pow(3, x) * 2);
        }


    }
}
// @lc code=end

