
import java.util.Scanner;

/**
 * @author Hongliang Zhu
 * @create 2020-06-02 12:43
 */
public class binaryTrans {

    private Scanner scanner = new Scanner(System.in);


    /**
     * 十进制转二进制
     */
    public void tenToBi(){
        System.out.print("请输入一个十进制数字：");
        int n = scanner.nextInt();
        int []result = new int[32];
        int c = 0;
        while (n > 0){
            result[c] = n % 2;
            n /= 2;
            c++;
        }
        // 打印输出
        for (int j = c - 1; j >=0; j--){
            //逆序输出
            System.out.print(result[j]);
        }
        System.out.println();

    }

    /**
     * 二进制转十进制
     */
    public void biToTen(){
        System.out.print("请输入一个二进制数据：");
        long bi = scanner.nextLong();
        int []result = new int[32];
        int c = 0;
        int sum = 0;
        while (bi != 0){
            long m = bi % 10;
            sum += (int) (m*Math.pow(2, c));
            bi /= 10;
            c++;
        }
        System.out.println(sum);


    }

    /**
     * 十进制转十六进制
     */
    public void teenToHex(){
        String s = "0123456789ABCDEF";
        char[] result = new char[32];
        int c = 0;
        System.out.print("请输入一个十进制数字：");
        int n = scanner.nextInt();
        while (n > 0 ){
            int i = n % 16;
            result[c++] = s.charAt(i);
            n /= 16;
        }
        // 打印输出
        for (int j = c - 1; j >=0; j--){
            //逆序输出
            System.out.print(result[j]);
        }
        System.out.println();


    }

    /**
     * 十六进制转十进制
     */
    public void HexToTen(){

    }


    public static void main(String[] args) {

        binaryTrans binaryTrans = new binaryTrans();
//        binaryTrans.tenToBi();
//        binaryTrans.biToTen();
        binaryTrans.teenToHex();


    }


}
