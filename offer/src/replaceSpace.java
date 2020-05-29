import java.util.SplittableRandom;

/**
 * @author Hongliang Zhu
 * @create 2020-05-29 23:20
 */

class Solution1 {
    public String replaceSpace(String s) {
//        String[] ss = s.split(" ");
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 32){
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }


    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 32){
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }


}

public class replaceSpace {
    public static void main(String[] args) {

        String s = "We are happy.";
//        String s = "   ";
        Solution1 solution = new Solution1();
        System.out.println(solution.replaceSpace(s));
    }
}


