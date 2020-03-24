package Sort;

/**
 *
 * 插入排序 简单实现
 *
 * @author Hongliang Zhu
 * @create 2020-03-18 22:56
 */
public class InsertSort {


    /**
     * 插入排序
     * @param arr
     */
    public static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i-1;
            int temp = arr[i];
            while (j >= 0 && temp < arr[j] ){ //前面的数更大，找到插入的位置
                arr[j+1] = arr[j];
                j--;
            }
            if(j + 1 != i) // 优化， 在存在比其大的数才会发生交换
                arr[j+1] = temp;
        }

    }

    public static void main(String[] args) {
        int[] a = {5, 7, 0, 6, 8, 1, 8, 4, 6, 6, 5};
        sort(a);
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }





}
