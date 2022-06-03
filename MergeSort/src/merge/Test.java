package merge;

import java.util.Arrays;

/**
 * @Created: 29/05/2022
 * @author: hasan.khan
 */
public class Test {


    public static void main(String[] args) {
        int[] ints = Utils.generateArrayWithRandomNumber(10, 100, 1);
        int[] ints1 = Arrays.copyOf(ints, 10);
        int[] ints2 = Arrays.copyOf(ints, 10);


        long startTime = System.nanoTime();
        // ... the code being measured ...
        mergeSort(ints, 0, ints.length);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Optimized Array: " + Arrays.toString(ints));

        System.out.println("Time: " + estimatedTime + " ns");
      //  System.out.println("Time: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS) + " ms");


        long startTime2 = System.nanoTime();
        int[] mergeSort = mergeSort(ints1);
        long estimatedTim2 = System.nanoTime() - startTime2;
        System.out.println("UnOptimized Array: " + Arrays.toString(mergeSort));

        System.out.println("Time: " + estimatedTim2 + " ns");
       // System.out.println("Time: " + TimeUnit.MILLISECONDS.convert(estimatedTim2, TimeUnit.NANOSECONDS) + " ms");

        System.out.println("Diff : " + (estimatedTim2 - estimatedTime));

       // System.out.println("mild Optimized Array: " + Arrays.toString(mergeSort));

        long startTime3 = System.nanoTime();
        int[] mergeSort3 = myMergeSort(ints2);
        long estimatedTim3 = System.nanoTime() - startTime3;
        System.out.println("mild Optimized Array: " + Arrays.toString(mergeSort3));

        System.out.println("Time: " + estimatedTim3 + " ns");
       // System.out.println("Time: " + TimeUnit.MILLISECONDS.convert(estimatedTim3, TimeUnit.NANOSECONDS) + " ms");

        System.out.println("Diff : " + (estimatedTim3 - estimatedTime));


        long[] pos = new long[3];
        pos[0]= estimatedTime;
        pos[2]= estimatedTim3;
        pos[1]= estimatedTim2;

        Arrays.sort(pos);
        System.out.println("\n--- Result ----");
        for (int i = 0; i < pos.length; i++) {
            System.out.println(i+1 + " position "+pos[i]);
        }

        int[] arr1 = {1, 5};
        int[] arr3 = {7, 3, 1};
       // copyArraysTest(arr1, arr3);

    }
    /** POC for copy array to optimize algorithm */
    private static void copyArraysTest(int[] arr1, int[] arr2) {
        System.out.println("Array1: " + Arrays.toString(arr1));
        System.out.println("Array2: " + Arrays.toString(arr2));
        /*  int[] arr1 = {1, 5};
        int[] arr3 = {7, 3, 1};*/

        int[] combineArr = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, combineArr, 0, arr1.length);

        System.out.println("combine: " + Arrays.toString(combineArr));

        System.arraycopy(arr2, 0, combineArr, arr1.length, arr2.length);

        System.out.println("combine: --> " + Arrays.toString(combineArr));


    }

    private static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        //  System.out.println("mid " + mid);


        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        mergeOptimized(input, start, mid, end);

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
      /*  int[] arr1 = {1, 5};
        int[] arr3 = {7, 3, 1};*/
        int[] leftSorted = mergeSort(left); //arr1;
        int[] rightSorted = mergeSort(right); //arr3;/

        return merge11(leftSorted, rightSorted);
        // merge the sorted halves
        //  return merge11(leftSorted, rightSorted);

    }

    public static int[] myMergeSort(int[] theArray) {

        // base case: single element array
        if (theArray.length <= 1) {
            return theArray;
        }

        // split the input in half
        int middleIndex = theArray.length / 2;
        int[] left = Arrays.copyOfRange(theArray, 0, middleIndex);
        int[] right = Arrays.copyOfRange(theArray, middleIndex, theArray.length);

        // sort each half
      /*  int[] arr1 = {1, 5};
        int[] arr3 = {7, 3, 1};*/
        int[] leftSorted = mergeSort(left); //arr1;
        int[] rightSorted = mergeSort(right); //arr3;/

        //return merge112(leftSorted, rightSorted);
        // merge the sorted halves
        return myMerge(leftSorted, rightSorted);

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

    public static int[] merge11(int[] input, int[] left) {
        // 1. need temp array to store value
        // 2. size of array for temp

        int indexArrOneIndex = 0;
        int indexArrTwoIndex = 0;
        int combineArrIndex = 0;

        int[] combineArray = new int[input.length + left.length];
        int[] arrOne = input;
        int[] arrTwo = left;

        // System.out.println("one: " + Arrays.toString(arrOne));
        // System.out.println("two: " + Arrays.toString(arrTwo));

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

        //   System.out.println("Combine: " + Arrays.toString(combineArray));


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

        // System.out.println("Last Combine: " + Arrays.toString(combineArray));

        return combineArray;

    }


    public static int[] myMerge(int[] input, int[] left) {
        // 1. need temp array to store value
        // 2. size of array for temp

        int indexArrOneIndex = 0;
        int indexArrTwoIndex = 0;
        int combineArrIndex = 0;

        int[] combineArray = new int[input.length + left.length];
        int[] arrOne = input;
        int[] arrTwo = left;

        // System.out.println("one: " + Arrays.toString(arrOne));
        // System.out.println("two: " + Arrays.toString(arrTwo));


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

        //   System.out.println("Combine: " + Arrays.toString(combineArray));

        // r: {1,5} and l : {7,3,1} // index 2
       /* while (indexArrOneIndex < arrOne.length) {
            combineArray[combineArrIndex] = arrOne[indexArrOneIndex];
            indexArrOneIndex++;
            combineArrIndex++;
        }*/

      //  System.out.println("Before Combine: " + Arrays.toString(combineArray));
       // System.out.println("Arr two: " + Arrays.toString(arrTwo));
        //  System.out.println("Before Combine: " + Arrays.toString(combineArray));

        if (indexArrTwoIndex < arrTwo.length) {
           // System.out.println("index2: " + indexArrTwoIndex + "  length: " + arrTwo.length);
            System.arraycopy(arrTwo, indexArrTwoIndex, combineArray, combineArrIndex,
                    arrTwo.length - indexArrTwoIndex);
        }

        if (indexArrOneIndex < arrOne.length) {
            System.arraycopy(arrOne, indexArrOneIndex, combineArray, combineArrIndex, arrOne.length - indexArrOneIndex);
        }

       // System.out.println("After Combine: " + Arrays.toString(combineArray));

        //  System.arraycopy(arr1,0,combineArr,0,arr1.length);

        //  System.out.println("combine: "+Arrays.toString(combineArr));

        //System.arraycopy(arr2,0,combineArr,arr1.length,arr2.length);


       /* while (indexArrTwoIndex < arrTwo.length) {
            combineArray[combineArrIndex] = arrTwo[indexArrTwoIndex];
            indexArrTwoIndex++;
            combineArrIndex++;
        }*/

        // System.out.println("Last Combine: " + Arrays.toString(combineArray));

        return combineArray;

    }


}
