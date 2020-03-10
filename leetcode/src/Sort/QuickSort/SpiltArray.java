package Sort.QuickSort;
/**
 * 荷兰国旗问题一：
 * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，
 * 大于num的数放在数组的右边。 要求额外空间复杂度O(1)，时间复杂度O(N)；
 *
 * @author Hongliang Zhu
 * @create 2020-03-10 23:22
 */
public class SpiltArray {

    public static void splitArray_(int[] arr, int num) {
        if (arr == null || arr.length < 2) return;
        sort(arr, 0, arr.length - 1, num);
    }

    public static void sort(int[] arr, int left, int right, int num) {
        int less = left - 1;
        while (left <= right) {
            if (arr[left] <= num) {
                swap(arr, ++less, left++);
            } else {
                left++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 8, -2, 4, 3, 4, 2, 8, 12, 3, 9, 8, 10, 9, 5, -1, 4, 9, 2};
        int[] arr = {1, 2, 8, 4, 3, 12, 10, 9, 2, 3};
        splitArray_(arr, 6);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
