package Sort.QuickSort;

/**
 * 快速排序优化，随机快速排序
 * @author Hongliang Zhu
 * @create 2020-03-10 22:13
 */
public class quickS1 {

    public static void quickSort(int[] arrs){
        if(arrs == null || arrs.length < 2) return;
        quick(arrs, 0, arrs.length-1);
    }

    /**
     *
     * @param arr  数组
     * @param left  左边界 0
     * @param right 右边界 下标
     */
    public static void quick(int[] arr, int left, int right){
        if(left < right){
            // 随机选择一个数域最后一个数进行交换
            swap(arr, left+(int)(Math.random()*(right-left+1)), right);  // Math.random() 返回[0, 1) 的随机数
            int[] pivot = partition(arr, left, right);
            quick(arr, left, pivot[0] - 1);
            quick(arr, pivot[0]+1, right);
        }

    }

    //  以数组最后一个元素为轴枢，将整个数组划分为 小于、等于、大于 三个部分
    public static int[] partition(int[] arr, int left, int right){
        int less = left - 1;
        int greater = right;
        while (left < greater){
            if (arr[left] < arr[right]){
                less++;
                swap(arr, less, left);//
                left++;
            }else if( arr[left] > arr[right]){
                // 交换more前一个元素
                greater--;
                swap(arr, left, greater);
            }else {
                left++;
            }
        }
        swap(arr, left, right);
        return new int[]{less + 1, greater};

    }

    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {43, -31, 10, -38, -42, -2, 22, 29, 30, 15, -60, -50, -13, 26, 3, 22, 27, 24, 18, 18, 42, -40, 22, 8, 33, -52, -70, -55, 31, 42, 82, 19, -8, 8, 41, -35, 59, 65, -23, 3, -34, 65};
        quickSort(arr);
        for (int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();

    }

}
