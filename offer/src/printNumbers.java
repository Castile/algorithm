/**
 *
 * 面试题17. 打印从1到最大的n位数
 *
 * 考虑大数越界打印问题
 *
 * @author Hongliang Zhu
 * @create 2020-06-16 21:50
 */
public class printNumbers {
    char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] num ;
    StringBuilder sb;
    int N;
    public static void main(String[] args) {
        printNumbers p = new printNumbers();
        p.print(2);

    }

    public  void print(int n){
        this.N = n;
        sb = new StringBuilder();  // 当前结果
        num = new char[n];
        dfs(0);

//        sb.deleteCharAt(0);
//        sb.deleteCharAt(sb.length() - 1);

        String substring = sb.substring(N+1, sb.length() - 1);
        System.out.println(substring);
    }

    public void dfs(int x){
       if(x == N){
           char[] tmp = new char[N];
           int index = 0;
           int k = 0;
           while (index < N && num[index] == '0'){
               index++;
           }
           while (index < N){
               tmp[k++] = num[index++];
           }
           sb.append(String.valueOf(tmp)+",");

           return;

       }

       for(char c: chars){
           num[x] = c;
           dfs(x+1);
       }

    }

}
