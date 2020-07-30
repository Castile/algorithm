package window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hongliang Zhu
 * @create 2020-07-30 13:19
 *
 * leetcode 567: 字符串的排列
 *
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode567_checkInclusion {

    /**
     * 滑动窗口   与最短子串覆盖的模板一样
     * @param t
     * @param s
     * @return
     */
    public boolean checkInclusion(String t, String s) {
        Map<Character, Integer> needs = new HashMap<>(), window = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;

        int valid = 0; // 统计有多少字符满足了覆盖的要求
        while(right < s.length()){
            // 当前要加入窗口的字符
            char c = s.charAt(right);
            right++; //  右指针++
            if(needs.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 看看字符数量是否达到要求
                if(window.get(c).equals(needs.get(c)))   valid++;
            }
            // 看看是否满足要求
            while(right - left  >= t.length()){  //  只需修改此处
                if(valid == needs.size()){  //  只需修改此处
                    return true;
                }
                char lc = s.charAt(left);
                left++; //  左指针++
                if(needs.containsKey(lc)){
                    // 看看字符数量是否达到要求
                    if(window.get(lc).equals(needs.get(lc)))   valid--;
                    window.put(lc, window.getOrDefault(lc, 0) - 1);
                }
            }

        }

        return false;
    }


    public boolean checkInclusion1(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>(), window = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            needs.put(s1.charAt(i), needs.getOrDefault(s1.charAt(i) , 0) + 1);
        }
        int left = 0, right = s1.length();
        while(right <= s2.length()){
            // 重置
            int valid = 0;

            for(int i = left; i <  right; i++){
                char c = s2.charAt(i);
                if(needs.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if(needs.get(c).equals(window.get(c))){
                        valid++;
                        if( valid == needs.size()){
                            return true;
                        }
                    }
                }else{
                    break;
                }

            }
            left++;
            right++;
            // 清空window
            window.clear();

        }

        return false;
    }

    public static void main(String[] args) {
        leetcode567_checkInclusion solution  = new leetcode567_checkInclusion();
        boolean b = solution.checkInclusion("abcdxabcdex",
                "abcdeabcdxx");
        System.out.println(b);
    }

}
