package Sort;


/**
 * 逆序对问题
 * @author Hongliang Zhu
 * @create 2020-03-02 23:34
 */
public class reversepair {

    public static int merge(int[] nums,  int low, int high){
        if(low == high) return 0;
        int mid = low + ((high  - low) >> 1);
        return merge(nums, low, mid) + merge(nums, mid+1, high)+ mergr_op(nums, low, mid, high);
    }

    public static int mergr_op(int[] nums, int low, int mid, int high){
        int k = 0;
        int[] help = new int[high  - low +1];
        int p1 = low;
        int p2 = mid+1;
        int res = 0; // 逆序对的个数
        while(p1 <= mid && p2 <= high){
            if(nums[p1] <= nums[p2]){
                help[k++] = nums[p1++];
            }else if(nums[p1] > nums[p2]){
                res+=(mid - p1  + 1);
                help[k++] = nums[p2++];
            }

        }
        while(p1 <= mid){
            help[k++] = nums[p1++];
        }
        while(p2 <= high){
            help[k++] = nums[p2++];
        }
        //copy
        for(int i = 0; i < high  - low +1; i++){
            nums[low + i] = help[i];
        }
        return res;
    }

    public static void print(int[] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+ " ");
        }
        System.out.println();
    }

    public static int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,5, 1};
        int res = reversePairs(nums);
        System.out.println(res);

//        merge(nums, 0, nums.length -1);
//        print(nums);
    }


}
