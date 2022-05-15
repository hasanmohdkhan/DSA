import java.util.concurrent.TimeUnit;

/**
 * Selection sort
 * ---------------------------
 * -select largest item in array and save index
 * -moved that largest item to last of array
 * -swap item
 *
 *  -> unstable sort = does not guaranty ordering of duplicate item
 *
 */
public class SelectionSortApplication {

    public static void main(String[] args) {
        int[] data = {20, 35, -15, 1, -22, -1, 100, 3, 21, 10, 60, 12, 189, -6, -11, 90, 0};

        long startTime = System.nanoTime();

        //traversing array in desc order i.e. from last index to first
        for (int lastSortedIndex = data.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            // initial largest item index is assume to be 0
            int largestItemIndex = 0;

            //leaving index 0 and starting from 1 index and comparing to last index using '<='
            // compare last index
            for (int i = 1; i <= lastSortedIndex; i++) {

                //checking current item is greater than the previous largest index or not
                if (data[i] > data[largestItemIndex]) {
                    largestItemIndex = i;
                }
            }
            swap(data, largestItemIndex, lastSortedIndex);


        }


        long stopTime = System.nanoTime();

        for (int datum : data) {
            System.out.print(" " + datum + ",");
        }


        time(startTime, stopTime);

    }

    private static void time(long startTime, long stopTime) {
        long l = stopTime - startTime;
        System.out.println("\n\n Time: " + TimeUnit.NANOSECONDS.toMillis(l) + " nanoSec");
    }


    /**
     * method to swap the two value
     *
     * @param arr array
     * @param i   index n
     * @param j   index n+1
     */
    public static void swap(int[] arr, int i, int j) {
        //both are equal no swap required
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }


}