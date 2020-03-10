package Sort.QuickSort;

/**
 * 荷兰国旗问题二：
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，
 * 等于num的数放在数组的中间，大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 *
 * @author Hongliang Zhu
 * @create 2020-03-10 22:13
 */
public class SplitArray2 {

    public static int[] SplitArray2(int[] arrs, int num) {
        if (arrs == null || arrs.length < 2) return null;
        int[] p = sort(arrs, 0, arrs.length - 1, num);
        return p;
    }


    //  以数组最后一个元素为轴枢，将整个数组划分为 小于、等于、大于 三个部分
    public static int[] sort(int[] arr, int left, int right, int num) {
        int less = left - 1;
        int greater = right + 1;
        while (left < greater) {
            if (arr[left] < num) {
                swap(arr, ++less, left++);

            } else if (arr[left] > arr[right]) {
                swap(arr, --greater, left);
            } else {
                left++;
            }
        }
        swap(arr, left, right);
        return new int[]{less + 1, greater};

    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        int[] arr = {43, -31, 10, -38, -42, -2, 22, 29, 30, 15, -60, -50, -13, 26, 3, 22, 27, 24, 18, 18, 42, -40, 22, 8, 33, -52, -70, -55, 31, 42, 82, 19, -8, 8, 41, -35, 59, 65, -23, 3, -34, 65};

        int[] arr = {1, 2, 6, 4, 8, 6, 10, 12, 6, 9, 2, 3};

        int[] p = SplitArray2(arr, 6);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("==============");
        System.out.println("小于的区域：");
        for (int i = 0; i < p[0]; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("==============");
        System.out.println("等于的区域：");
        for (int i = p[0]; i <= p[1]; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("==============");
        System.out.println("大于的区域：");
        for (int i = p[1]+1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


    }

}
