import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.introcs.StdOut;

import java.io.File;

/**
 * java FileSorter "directory path"
 * Created by William on 2015/7/10.
 */
public class FileSorter {

    public static void main(String[] args) {
        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        Insertion.sort(files);
        for (int i = 0; i < files.length; i++) {
            StdOut.println(files[i].getName());
        }
    }
}
