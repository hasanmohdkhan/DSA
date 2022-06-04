package selectionsortpractice;

import java.util.Arrays;

/**
 * @Created: 26/05/2022
 * @author: hasan.khan
 */
public class SelectionSortPractice {

    public static void main(String[] args) {

        int worstCase10L = 10;
        int[] arrayWithRandomNumber = Utils.generateArrayWithRandomNumber(worstCase10L,1,10);
        int[] copy = Arrays.copyOf(arrayWithRandomNumber, arrayWithRandomNumber.length);
        long startTime = System.currentTimeMillis();
        selectionSort(arrayWithRandomNumber);
        long endTime = System.currentTimeMillis();
        Utils.time(startTime,endTime);

        selectionSortP1(copy);
    }


    public static void selectionSort(int[] arr) {
        System.out.println("\nRunning Selection sort...");

        for (int largestIndex = 0; largestIndex < arr.length; largestIndex++) {
            System.out.println("\nindex: "+largestIndex);

            int smallIndex = largestIndex;

            for (int j = largestIndex+1; j < arr.length; j++) {
                if(arr[j] < arr[smallIndex]){
                    smallIndex = j;
                }
            }
            swap(arr, largestIndex, smallIndex);
        }

        System.out.println("\nSort ....");
        for(int j : arr){
            System.out.print(j+ " ");
        }
    }

    private static void swap(int[] arr, int i, int smallIndex) {
        int temp = arr[smallIndex];
        arr[smallIndex] = arr[i];
        arr[i] = temp;
    }


    private static void selectionSortP1(int[] data) {

        for (int i = 0; i < data.length; i++) {

            int smallIndex= i;

            for (int j = i+1; j < data.length; j++) {
                if(data[j] < data[smallIndex]){
                    smallIndex = j;

                }
                swap(data,i,smallIndex);
            }

        }

        System.out.println("P2: "+ Arrays.toString(data));

    }
}
