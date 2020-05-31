import java.util.Arrays;

/**
 * 剑指offer ： 变态跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author Hongliang Zhu
 * @create 2020-05-31 16:05
 */
public class JumpFloorII {

    public static void main(String[] args) {

        System.out.println(JumpFloorII(4));
        System.out.println(JumpFloorII_math(4));

    }


    /**
     *  动态规划
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for(int i = 1; i < target; i++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j];
            }
        }

        return dp[target-1];

    }

    /**
     *
     * 数学： 等比数列
     */
    public static int JumpFloorII_math(int target) {
        return (int)Math.pow(2, target-1);
    }




}
