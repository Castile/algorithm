
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * [编程题]跳石板  网易秋招
 * @author Hongliang Zhu
 * @create 2020-05-31 21:31
 */
public class skipStone {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 起始位置
        int M = sc.nextInt(); //  终止位置

        int []dp = new int[M+1]; //  dp[i] ： 到第i个石块最少需要跳多少次。
        Arrays.fill(dp, Integer.MAX_VALUE); //  均初始化为无穷大
        dp[N] = 0; // 自己到自己跳0次

        for(int i = N; i <= M; i++){
            if(dp[i] == Integer.MAX_VALUE) continue; //  不可达
            // 遍历 当前i的约数
            ArrayList<Integer> factors = getFactors(i);
            for(int j = 0;  j < factors.size(); j++){
                int skip = i+factors.get(j);
                if(skip > M){
                    continue;
                }
                if(dp[skip] == Integer.MAX_VALUE){
                    dp[skip] = dp[i]+1;
                }else {
                    dp[skip] = Math.min(dp[skip], dp[i]+1);
                }
            }

        }

        if(dp[M] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[M]);
    }

    /**
     * 获得当前数的约数 ， 除了1和它自己
     * @param n
     * @return
     */
    public static ArrayList<Integer> getFactors(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                list.add(i);
                if(n / i != i){
                    list.add(n / i);
                }
            }
        }
        return list;
    }





}
