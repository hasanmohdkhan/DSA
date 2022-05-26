package selectionsortpractice;

import java.util.concurrent.TimeUnit;

/**
 * @Created: 26/05/2022
 * @author: hasan.khan
 */
public class Utils {
    public static final int WORST_CASE_10L = 1000000;
    public static int[] generateArrayWithRandomNumber(int length) {
        int[] arr = new int[length];
        int max = 10000;
        int min = 1;

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        System.out.println("Unsorted Array:");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        return arr;

    }

    public static void time(long startTime, long stopTime) {
        long l = stopTime - startTime;
        System.out.println("\n\n Time: " + TimeUnit.MILLISECONDS.toSeconds(l) + " sec");
    }

}
