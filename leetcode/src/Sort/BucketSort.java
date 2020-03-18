package Sort;

import java.util.Arrays;

/**
 * 桶排序
 * @author Hongliang Zhu
 * @create 2020-03-18 22:32
 */
public class BucketSort {

    /**
     * 计数排序
     * @param arr
     */
    public static void ConutSort(int []arr){
        if(arr == null || arr.length < 2){
            return;
        }
        // 找出数组中的最大值  O(n)
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        // 建桶，max+1 个桶，
        int[] bucket =  new int[max+1];
        for(int i = 0;  i< arr.length; i++){
            bucket[arr[i]]++; // 对应的桶序号加上1
        }
        //还原排序
        int k = 0;
        for(int i = 0; i < bucket.length; i++){
            while (bucket[i] > 0){
                arr[k++] = i;
                bucket[i]--;
            }
        }


    }

    /**
     * 桶排序
     * @param arr  待排序的数组
     * @param size  每个桶的大小
     */
    public static int[] bucketSort(int[] arr, int size){
        if (arr.length == 0)    return arr;
        // 对arr拷贝，不影响原来的数组
        int[] a = Arrays.copyOf(arr, arr.length);

        // 算出最大最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int value: a){
            min = Math.min(value, min);
            max = Math.max(value, max);
        }

        // 桶的个数
        int bucketConut = (int) (Math.floor((max - min ) / size ) +1);
        int[][] buckets = new int[bucketConut][0];
        // 利用映射函数将数据分配到各个桶中
        for(int i = 0; i < arr.length; i++){
            int index = (int) Math.floor(( arr[i] - min ) / size); // 属于那个桶
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }
        // 接下来对每个桶进行排序
        int k=0;
        for(int[] b: buckets){
            if(b.length <= 0){
                continue;
            }
            // 排序
            InsertSort.sort(b);
            // 还原到原数组中
            for(int value: b){
                a[k++] = value;
            }

        }

        return a;

    }
    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 0, 6, 8, 1, 8, 4, 6, 6, 5};

//        ConutSort(a);
        int[] arr = bucketSort(a, 3);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();

    }



}
