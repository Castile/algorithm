package Str;

/**
 * @author Hongliang Zhu
 * @create 2020-02-03 16:57
 */
/*
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。


示例 1：

输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
示例 2：

输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]

 */
public class leetcode344_ReverseStr {
    public void reverseString(char[] s) {
        int len = s.length;
        char tmp;
        for (int i = 0; i < len / 2; i++) {
            tmp = s[i];
            s[i] = s[len - i - 1]; //这是末尾的值
            s[len - i - 1] = tmp;
        }
    }

    public void reverseString_Recur(char[] s) {
        help(s, 0, s.length);

    }

    private void help(char[] s, int i, int j) {
        if (i >= j) return;
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        i++;
        j--;
        help(s, i, j);
    }

}
