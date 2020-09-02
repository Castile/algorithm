package Str;

/**
 * @author Hongliang Zhu
 * @create 2020-09-01 22:34
 *
 * 翻转字符串
 *
 */
public class ReverseWords {

    static String res = "";
    public static String reverseWords(String s) {
        String[] split = s.trim().split(" +");
        reverse(split, 0);
        System.out.println(res);
        return res.substring(0, res.length()-1);
    }

    private static void reverse(String[] split, int pos) {
        if(pos == split.length) {
            return;
        }
        reverse(split, pos+1);
        res+=split[pos];
        if (pos != split.length){
            res+=" ";
        }
    }

    public static void main(String[] args) {
        String s ="  hello world!  ";
        reverseWords(s);

    }

}
