package RecurrenceAndDynamicProgramming;

/**
 * @author Hongliang Zhu
 * @create 2020-02-16 14:22
 */
/*
在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。

给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）

 */
public class leetcode799_kthGrammar {

    public  int kthGrammar(int N, int K) {
        if(N==1) return 0;
        int ans = kthGrammar(N-1, (K+1)>>1);
        if(ans==1) {
            return K%2==0?0:1;
        } else {
            return K%2==0?1:0;
        }
    }


}
