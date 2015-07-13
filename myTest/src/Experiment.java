import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by William on 2015/7/10.
 */
public class Experiment {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();

        }
        Insertion.sort(a);
        for (int j = 0; j < N; j++) {
            StdOut.println(a[j]);
        }

    }
}
