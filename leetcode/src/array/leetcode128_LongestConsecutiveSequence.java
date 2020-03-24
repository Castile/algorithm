package array;

import java.util.HashSet;

/**
 * @author Hongliang Zhu
 * @create 2020-01-22 18:15
 */

/*
给定一个未排序的整数数组，找出最长连续序列的长度。
要求算法的时间复杂度为 O(n)。
 */
public class leetcode128_LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> myset = new HashSet<>();
        for(int i: nums){
            myset.add(i);
        }
        int longest = 0;
        for(int i: nums) {
            int len = 1;
            for(int j = i+1; myset.contains(j); j++){
                myset.remove(j);
                len++;
            }
            for (int j = i - 1; myset.contains(j); j--){
                myset.remove(j);
                len++;
            }
            longest = Math.max(longest, len);
        }

        return longest;

    }




    public static void main(String[] args) {
        int []nums = {100, 4, 200, 1, 3, 2};
        int len = longestConsecutive(nums);
        System.out.println(len);

    }
}
