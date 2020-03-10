package Sort.QuickSort;

/**
 * 快速排序
 *
 * @author Hongliang Zhu
 * @create 2020-03-10 20:52
 */
public class quickSort {

    public void quickSort(int[] arrs, int low, int high) {
        if (arrs == null || arrs.length == 0) return;
        if(low < high){
            int Pivot = Patition(arrs, low, high);
            quickSort(arrs, low, Pivot-1);
            quickSort(arrs, Pivot + 1, high);
        }

    }

    // 选定一个轴枢，在其左边的都比他小， 在其右边的都比他大
    public int Patition(int[] arrs, int low, int high) {
        int p = arrs[low];
        int i = low;
        int j = high;
        while (i < j){
            while (arrs[j] > p && i < j) {
                j--;
            }
            if(i < j)
                swap(arrs, j, i++);
            while (arrs[i] <= p && i < j) {
                i++;
            }
            if(i < j)
                swap(arrs, i, j--);

        }

        for(int k: arrs){
            System.out.print(k+" ");
        }
        System.out.println();

        return i;


    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        quickSort quickSort = new quickSort();
//        int[] arr = {4, 3, 5, 1, 2, 6};
        int[] arr = {43, -31, 10, -38, -42, -2, 22, 29, 30, 15, -60, -50, -13, 26, 3, 22, 27, 24, 18, 18, 42, -40, 22, 8, 33, -52, -70, -55, 31, 42, 82, 19, -8, 8, 41, -35, 59, 65, -23, 3, -34, 65};
//        int p = quickSort.Patition(arr, 0, arr.length-1);
//        System.out.println(p);
        quickSort.quickSort(arr, 0, arr.length-1);
        for(int k: arr){
            System.out.println(k);
        }
    }


}
