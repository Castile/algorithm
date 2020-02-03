/**
 * @author Hongliang Zhu
 * @create 2020-01-25 23:24
 */
public class main {

    public static void main(String[] args) {
        UF dj = new UF(6);
        System.out.println(dj.count());
        dj.union(0,1);
        dj.union(1,2);
//        dj.union(2,3);
        System.out.println(dj.count());

        dj.union(4,5);
//        dj.union(5,6);

        System.out.println(dj.count());
        System.out.println(dj.find(2));
        System.out.println(dj.find(5));

        System.out.println("0 和 5连通吗："+ dj.isSameSet(0, 5));
        dj.union(0,5);
        System.out.println("0 和 5连通吗："+ dj.isSameSet(0, 5));

    }

}
