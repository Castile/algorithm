/**
 *
 * 剑指offer ： 面试题11. 旋转数组的最小数字
 * @author Hongliang Zhu
 * @create 2020-05-31 12:43
 */
public class minArray {

    public int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0)
            return -1;
        for(int i = 0; i < numbers.length -1; i++){
            if(numbers[i] > numbers[i+1]){
                return numbers[i+1];
            }
        }

        return -1;

    }

}
