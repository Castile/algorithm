package Sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hongliang Zhu
 * @create 2020-02-28 20:08
 */

/*
一个有序数组A，另一个无序数组B，请打印B中的所有不在A中的数，A数 组长度为N，B数组长度为M。
 */
public class GetNotInArrays {

    // 方法一： 暴力 O(M*N)
    public List<Integer> getNotInArrays(int[] A, int[] B){
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int a: A){
            list.add(a);
        }
        //循环遍历B数组
        for(int i = 0; i < B.length; i++){
            if(!list.contains(B[i])){
                res.add(B[i]);
            }
        }
        return res;
    }

    // 方法二： 二分查找  O(M*longN)
    public List<Integer> getNotInArrays_V2(int[] A, int[] B){
        List<Integer> res = new ArrayList<>();
        boolean contains = false;
        for(int i: B){
            int low = 0;
            int high = A.length - 1;
            while(low <= high){
                int mid = (low+high) >> 1;
                if(A[mid] == i ) {
                    contains = true;
                    break;  //找到了
                }
                else if(A[mid] > i){ //  在A的左边， 更改low和high
                    high = mid - 1;
                }else if(A[mid] < i){ //  在A的右边， 更改low和high
                    low = mid + 1;
                }
            }
            if(!contains){ //  不存在
                res.add(i);
            }
            contains = false; // 复位
        }
        return res;
    }

    // 方法三： 对B先排序，然后使用外部排序来 求解
    public List<Integer> getNotInArrays_V3(int[] A, int[] B) {
        // 对B先 排序
        Arrays.sort(B);
        List<Integer> res = new ArrayList<>();
        int a = 0;
        int b = 0;
        while ((a < A.length) && (b < B.length)) {
            if (A[a] == B[b]) {
                a++;
                b++;
            } else if (A[a] < B[b]) {
                a++;
            } else if (A[a] > B[b]) {
                res.add(B[b]);
                b++;
            }
        }
        while (b < B.length){
            res.add(B[b++]);
        }
        return res;

    }


    public static void main(String[] args) {
        GetNotInArrays solution = new GetNotInArrays();
        int[] A = {1,3,4,6,7,8,9,10};
        int[] B = {1,0,2,5,11,33,9};
//        List<Integer> res = solution.getNotInArrays(A, B);
//         List<Integer> res = solution.getNotInArrays_V2(A, B);
        List<Integer> res = solution.getNotInArrays_V3(A, B);
        for(int i: res){
            System.out.println(i);
        }

    }

}
