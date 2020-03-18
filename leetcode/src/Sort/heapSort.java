package Sort;
/**
 *
 * 堆排序
 * @author Hongliang Zhu
 * @create 2020-03-18 20:05
 */
public class heapSort {

    /**
     * 构造一个大根堆
     * @param arr
     */
    public static void InsertToHeap(int []arr){
        for(int i = 1; i < arr.length; i++){
            int index = i;
            while (arr[index] > arr[(index-1) / 2]){ // 左子节点大于父节点
                swap(arr, index, (index-1) / 2);
                index = (index-1) / 2; //  一直向上找到父节点。
            }
        }
    }

    /**
     * 将位置k的元素向下调整，使其符合堆结构
     * @param arr
     * @param k
     * @param size  当前堆结构的大小
     */
    public static void heapAdjustDown(int[] arr, int k, int size){
        int left = 2*k +1; // 左孩子的下标
        while (left < size){
            // 选出两个孩子中最大的那个
            int largest = arr[left] < arr[left+1] && left+1 < size ? left+1:left;
            largest = arr[largest] > arr[k]? largest:k;
            if(largest == k){ // 已经是根节点最大，无需调整
                break;
            }
            // 调整
            swap(arr, k, largest);
            k = largest;
            left = 2*k +1;

        }
    }

    /**
     * 堆排序  基于大根堆
     * @param arr
     */
    public static void HeapSort(int[] arr){
        // 堆顶元素是最大的元素， 将 堆顶元素与最后一个元素对换， 然后size-1； 再向下调整，直至成为一个新的大顶堆
        // 首先构造大根堆
        InsertToHeap(arr);
        int len = arr.length;
        swap(arr, 0, --len); // 与最后一个元素交换
        while (len > 0){
            // 向下调整堆结构
            heapAdjustDown(arr, 0, len);
            swap(arr, 0, --len);
        }

    }


    public static void swap(int arr[], int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int [] a = { 5,7,0,6,8 };
        HeapSort(a);
        for (int i:a){
            System.out.print(i+"\t");
        }
        System.out.println();

    }




}
