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


        int[] input = {1, 5, 7, 3, 1};
        mergeSort(input, 0, input.length);

        long estimatedTime = System.nanoTime() - startTime;


        System.out.println("Sorted Array:");
        for (int j : ints) {
            System.out.println(j);
        }

        System.out.println("Time: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS) + " ms");


    }

    private static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        System.out.println("mid " + mid);


        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        mergeOptimized(input, start, mid, end);

        //merge1(input, start, mid, end);
      //  int[] mergeSort = mergeSort(input);
       // System.out.println("Unoptimized: " + Arrays.toString(mergeSort));
    }

    public static int[] mergeSort(int[] theArray) {

        // base case: single element array
        if (theArray.length <= 1) {
            return theArray;
        }

        // split the input in half
        int middleIndex = theArray.length / 2;
        int[] left = Arrays.copyOfRange(theArray, 0, middleIndex);
        int[] right = Arrays.copyOfRange(theArray, middleIndex, theArray.length);

        // sort each half
        int[] leftSorted = mergeSort(left);
        int[] rightSorted = mergeSort(right);

        // merge the sorted halves
        return merge11(leftSorted, rightSorted);
    }

    //[38, 32, 13, 27, 3, 58, 58, 9, 13, 22]
    private static void mergeOptimized(int[] input, int start, int mid, int end) {
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

        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        //optimization for copying array
        //
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }

    private static void merge2(int[] input, int start, int mid, int end) {
        //stores the starting position of both parts in temporary variables.
        int i = start;
        int j = mid + 1;
        int tempIndex = 0;

        System.out.println("i: " + i + " j " + j + " tempIndex " + tempIndex);

        int[] temp = new int[end - start + 1];

        for (int ii = start; ii <= end; ii++) {
            if (i > mid)      //checks if first part comes to an end or not .
                temp[tempIndex++] = input[j++];

            else if (j > end)   //checks if second part comes to an end or not
                temp[tempIndex++] = input[i++];

            else if (input[ii] < input[j])     //checks which part has smaller element.
                temp[tempIndex++] = input[i++];

            else
                temp[tempIndex++] = input[j++];
        }

        for (int o = 0; o < tempIndex; o++) {
            /* Now the real array has elements in sorted manner including both parts.*/
            input[start++] = temp[o];
        }
    }


    // {1,5,7,3,1}
    // mid  (0+5)/2  -> 2
    // arr, 0, 2, 4
    public static int[] merge1(int[] input, int start, int mid, int end) {
        // 1. need temp array to store value
        // 2. size of array for temp
        //  mid = 2

        System.out.println("s : " + start + " mid " + mid + " end " + end);

        int indexArrOneIndex = 0;
        int indexArrTwoIndex = 0;
        int combineArrIndex = 0;

        int[] combineArray = new int[start + end];
        int[] arrOne = Arrays.copyOfRange(input, start, mid);
        int[] arrTwo = Arrays.copyOfRange(input, mid, end);

        System.out.println("one: " + Arrays.toString(arrOne));
        System.out.println("two: " + Arrays.toString(arrTwo));

        // {1,5} and {7,3,1}
        //{1,

        while (indexArrOneIndex < arrOne.length && indexArrTwoIndex < arrTwo.length) {
            if (arrOne[indexArrOneIndex] < arrTwo[indexArrTwoIndex]) {
                combineArray[combineArrIndex] = arrOne[indexArrOneIndex];
                combineArrIndex += 1;
                indexArrOneIndex++;
            } else {
                combineArray[combineArrIndex] = arrTwo[indexArrTwoIndex];
                combineArrIndex += 1;
                indexArrTwoIndex++;
            }
        }

        System.out.println("Combine: " + Arrays.toString(combineArray));


        while (indexArrOneIndex < arrOne.length) {
            combineArray[combineArrIndex] = arrOne[indexArrOneIndex];
            indexArrOneIndex++;
            combineArrIndex++;
        }

        while (indexArrTwoIndex < arrTwo.length) {
            combineArray[combineArrIndex] = arrTwo[indexArrTwoIndex];
            indexArrTwoIndex++;
            combineArrIndex++;
        }

        System.out.println("Last Combine: " + Arrays.toString(combineArray));

        return combineArray;

    }


    public static int[] merge11(int[] input, int[] left) {
        // 1. need temp array to store value
        // 2. size of array for temp

        int indexArrOneIndex = 0;
        int indexArrTwoIndex = 0;
        int combineArrIndex = 0;

        int[] combineArray = new int[input.length + left.length];
        int[] arrOne = input;
        int[] arrTwo = left;

        System.out.println("one: " + Arrays.toString(arrOne));
        System.out.println("two: " + Arrays.toString(arrTwo));

        // {1,5} and {7,3,1}

        while (indexArrOneIndex < arrOne.length && indexArrTwoIndex < arrTwo.length) {
            if (arrOne[indexArrOneIndex] < arrTwo[indexArrTwoIndex]) {
                combineArray[combineArrIndex] = arrOne[indexArrOneIndex];
                indexArrOneIndex++;
            } else {
                combineArray[combineArrIndex] = arrTwo[indexArrTwoIndex];
                indexArrTwoIndex++;
            }
            combineArrIndex++;
        }

        System.out.println("Combine: " + Arrays.toString(combineArray));


        while (indexArrOneIndex < arrOne.length) {
            combineArray[combineArrIndex] = arrOne[indexArrOneIndex];
            indexArrOneIndex++;
            combineArrIndex++;
        }

        while (indexArrTwoIndex < arrTwo.length) {
            combineArray[combineArrIndex] = arrTwo[indexArrTwoIndex];
            indexArrTwoIndex++;
            combineArrIndex++;
        }

        System.out.println("Last Combine: " + Arrays.toString(combineArray));

        return combineArray;

    }


}
