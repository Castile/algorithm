package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hongliang Zhu
 * @create 2020-08-26 12:43
 *
 * leetcode17 :  电话号码的数字组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class leetcode17_letterCombinations {
    Map<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits)) return res;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "qprs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        backtrack(digits, 0 ,sb);
        return res;

    }

    public void backtrack(String digits, int pos, StringBuilder sb){
        if(pos == digits.length()){
            res.add(sb.toString());
            return;
        }
        Character c = digits.charAt(pos);
        String s = map.get(c);
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            backtrack(digits, pos+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        leetcode17_letterCombinations solution = new leetcode17_letterCombinations();
        List<String> list = solution.letterCombinations("23");
        System.out.println(list);
    }

}
