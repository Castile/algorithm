package MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Hongliang Zhu
 * @create 2020-08-03 10:41
 *
 * leetcode 496 下一个更大的数I
 *
 *
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextreaterNumberI {

    // 暴力
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums2.length; i++){
            map.put(nums2[i], i);

        }

        for(int i = 0 ; i < nums1.length; i++){
            int index = map.get(nums1[i]);
            index++;
            while(index < nums2.length){
                if(nums2[index] > nums1[i]){
                    res[i] = nums2[index];
                    break;

                }
                index++;
            }
            if( index >= nums2.length){
                res[i] = -1;
            }

        }

        return res;

    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack< Integer > stack = new Stack < > ();
        HashMap < Integer, Integer > map = new HashMap < > ();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek()) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }

}
