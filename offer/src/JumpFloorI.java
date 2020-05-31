/**
 * 剑指offer ： 跳台阶
 * @author Hongliang Zhu
 * @create 2020-05-31 16:03
 */
public class JumpFloorI {

    public static void main(String[] args) {
        System.out.println(JumpFloorI(30));
    }


    public static int JumpFloorI(int n) {
        if(n==0)return 1;
        if(n == 2 || n==1) return n;

        int[] a = new int[n+1];
        a[1] = 1;
        a[2] = 2;
        // a[3]=3;
        for(int i = 3; i <=n ;i++ ){
            a[i] = a[i-1] % 1000000007+a[i-2]%1000000007;
        }
        return a[n]%1000000007;

    }


}
