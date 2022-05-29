package merge;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Created: 29/05/2022
 * @author: hasan.khan
 */
public class MergeSortApplication {

    public static void main(String[] args) {
        int[] ints = Utils.generateArrayWithRandomNumber(10, 100, 1);


        long startTime = System.nanoTime();
        // ... the code being measured ...


        mergeSort(ints, 0, ints.length);

        long estimatedTime = System.nanoTime() - startTime;


        System.out.println("Sorted Array:");
        for (int j : ints) {
            System.out.println(j);
        }

        System.out.println("Time: "+TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS)+" ms");


    }

    private static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);

    }

    //[38, 32, 13, 27, 3, 58, 58, 9, 13, 22]
    private static void merge(int[] input, int start, int mid, int end) {
       // System.out.print(Arrays.toString(input));
      //  System.out.println("s: " + start + " mid: " + mid + " end: " + end);

        if (input[mid - 1] <= input[mid]) {
            // System.out.println("input[mid-1]"+ input[mid-1]+ "<= input[mid]" +input[mid]);
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end - start];

        while (i < mid && j < end){
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        //optimization for copying array
        //
        System.arraycopy(input,i,input,start+ tempIndex,mid-i);
        System.arraycopy(temp, 0 , input,start,tempIndex);

    }




}
