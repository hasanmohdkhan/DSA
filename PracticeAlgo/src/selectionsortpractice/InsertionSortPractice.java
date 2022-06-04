package selectionsortpractice;

import java.util.Arrays;

/**
 * @Created: 26/05/2022
 * @author: hasan.khan
 */
public class InsertionSortPractice {

    public static void main(String[] args) {
        int[] dataSet = Utils.generateArrayWithRandomNumber(3, 1, 100);
        int[] copyArr = Arrays.copyOf(dataSet, dataSet.length);
        int[] copyArr2 = Arrays.copyOf(dataSet, dataSet.length);
        insertionSort(dataSet);

        System.out.println("\npractice 2:");
        insertionSortP2(copyArr);

        System.out.println("\nP3");
        insertionNoLookup(copyArr2);

    }

    private static void insertionSort(int[] dataSet) {
        System.out.println("\ninsertionSort...");

        // as 0th is already sorted
        for (int i = 1; i < dataSet.length; i++) {
            int newElement = dataSet[i];
            int j;
            for (j = i; j > 0 && dataSet[j - 1] > newElement; j--) {
                dataSet[j] = dataSet[j - 1];
            }
            dataSet[j] = newElement;
        }

        for (int index : dataSet) {
            System.out.print(index + " ");
        }

    }

    private static void insertionSortP2(int[] data) {

        System.out.println("Unsorted Array: " + Arrays.toString(data));
        for (int i = 1; i < data.length; i++) {
            int newElement = data[i];

            int k;
            for (k = i; k > 0 && data[k - 1] > newElement; k--) {
                data[k] = data[k - 1];
            }
            data[k] = newElement;


        }


        System.out.println("Sorted Array: " + Arrays.toString(data));


    }


    private static void insertionNoLookup(int[] data) {

        for (int i = 1; i < data.length; i++) {
            int tempOrHighValue = data[i];

            int j;
            for (j = i; j > 0 && data[j - 1] > tempOrHighValue; j--) {
                data[j] = data[j - 1];
            }

            data[j] = tempOrHighValue;

            System.out.println("Sortedd : "+Arrays.toString(data));

        }

    }
}
