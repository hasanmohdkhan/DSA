import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Created: 09/06/2022
 * @author: hasan.khan
 */
public class QuickSortApplication {


    public static void main(String[] args) {
        int[] ints = Utils.generateArrayWithRandomNumber(10, 100, 1);

        long startTime = System.nanoTime();

        quickSort(ints,0, ints.length);

        long estimatedTime = System.nanoTime() - startTime;

        System.out.println("Sorted Array: "+ Arrays.toString(ints));

        System.out.println("Time: " + estimatedTime + " ns");
    }


    private  static void quickSort(int[] input, int start, int end) {
        /* return if diff is 1 */
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);


    }

    private  static int partition(int[] input, int start, int end) {

        int pivot = input[start];
        int i = start;
        int j = end;


        while (i < j) {

            //NOTE: empty loop body
            // just checking && decrementing j
            while (i < j && input[--j] >= pivot) ;

            // why checking i < j BECAUSE it may run body
            // while loop run
         //   if (i < j) {
                input[i] = input[j];
           // }
           // }

            //NOTE: empty loop body
            // just checking && incrementing i
            while (i < j && input[++i] <= pivot) ;

         //   if (i < j) {
                input[j] = input[i];
           // }


        }

        input[j] = pivot;
        return j;
    }


}
