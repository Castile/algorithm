/**
 * @author Hongliang Zhu
 * @create 2020-06-16 23:45
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class reOrderArray {


    public void reOrderArray(int[] array) {
        int oddcount = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                oddcount++;
            }
        }
        int k = 0;
        int m = oddcount;
        int[] copy = array.clone();
        for (int num : copy) {
            if ((num & 1) == 1) {
                array[k++] = num;
            } else {
                array[m++] = num;
            }
        }
    }

    // 借助 快排思想
    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            while( (nums[l] & 1) == 1 && l < r){
                l++;
            }
            while((nums[r] &  1) == 0 && l < r){
                r--;
            }
            swap(nums, l, r);
        }

        return nums;

    }

    private void swap(int[]nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args) {
        reOrderArray re = new reOrderArray();

        int[] a = {1, 2, 3, 4, 5, 6};
        re.reOrderArray(a);

        for (int u: a){
            System.out.println(u);
        }
    }

}
