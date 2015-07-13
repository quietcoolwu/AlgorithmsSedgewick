/**
 * 问题在哪里?
 * Created by William on 2015/7/1.
 */
public class isStringSorted {

    public static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1].compareTo(a[i]) > 0)
                return false;
        }

        return true;


    }

    public static void main(String[] args) {
        if (isSorted(args))
            System.out.println("True!");

        else System.out.println("False!");
    }
}
