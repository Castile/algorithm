package RecurrenceAndDynamicProgramming;
/**
 * @author Hongliang Zhu
 * @create 2020-02-12 15:39
 */
public class leetcode50_pow {

    public static double pow(double x, int n) {
        long N = n;
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }
        double ans = 1.0;
        for (int i = 0; i < N; i++) {
            ans *= x;
            ans %= 1000;
        }
        return ans;
    }

    /**
     *  快速幂
     * @param x 底数
     * @param n 指数
     * @return  结果   求最后三位数
     */
    public static double fast_pow(double x, int n){
        double result = 1;
        while (n > 0 ){
//            if(n % 2 == 0){
//                // 如果指数为偶数
//                n /= 2;
//                x = x * x % 1000;
//            }if(n % 2 != 0 ){
//                // 指数为奇数
//                n--; //  指数减一为偶数
//                result = result * x % 1000;
//                n /= 2;
//                x = x * x % 1000;
//            }
            if( (n & 1) == 1) {  // n%2 == 1  奇数   使用位运算更加高效
                result = result * x % 1000;
            }
            // n /= 2;
            n >>= 2; // 右移
            x = x * x % 1000;
        }
        return result % 1000;

    }

    public static void main(String[] args) {

        long start =  System.nanoTime();
//        double ans = pow(2, 1000000000);
        double anss = fast_pow(2, 10000000);
        long end = System.nanoTime();

        System.out.println(anss);
        System.out.println("耗时：" +  (end - start)   +" ns");

    }
}
