import java.util.Scanner;

/**
 * @author Hongliang Zhu
 * @create 2020-05-31 16:27
 */
public class point {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        double r = Math.sqrt(radius);
        int range = (int)Math.floor(r);
        int count = 0;
        for(int i = 1; i <= range; i++){
            for(int j = 1; j <= range;  j++){
                if( i*i + j*j == radius){
                    count++;
                }
            }

        }
        count*=4;
        if(range == r){
            count+=4;
        }
        System.out.println(count);

//        System.out.println(Math.sqrt(25)== (int)Math.floor(Math.sqrt(25) ));


    }

}
