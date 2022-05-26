package selectionsortpractice;

import java.util.Arrays;

/**
 * @Created: 26/05/2022
 * @author: hasan.khan
 */
public class InsertionSortPractice {

    public static void main(String[] args) {
        int[] dataSet = Utils.generateArrayWithRandomNumber(Utils.WORST_CASE_10L);
        insertionSort(dataSet);

        Arrays.sort(dataSet);
        insertionSort(dataSet);

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
}
