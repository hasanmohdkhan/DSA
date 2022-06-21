import java.util.Arrays;

/**
 * @Created: 20/06/2022
 * @author: hasan.khan
 */
public class CountingSort {
    public static void main(String[] args) {

        // int[] input = {10, 7, 8, 10, 6, 8, 5, 10, 1, 8};
        int[] input = Utils.generateArrayWithRandomNumber(10, 1, 10);
        System.out.println(Arrays.toString(input));
        countingSort(input);
        countingSortOpt(input, 1, 10);

    }

    private static void countingSort(int[] input) {
        int[] countingArray = new int[input.length + 1];

        for (int k : input) {
            countingArray[k - 1]++;
        }

        int[] test = new int[input.length];

        int j = 0;
        for (int i = 0; i < countingArray.length; i++) {
            int count = countingArray[i];
            while (count > 0) {
                test[j] = i + 1;
                count--;
                j++;
            }

        }
        System.out.print("my : ");
        System.out.println(Arrays.toString(test));

    }


    private static void countingSortOpt(int[] input, int min, int max) {
        int[] countingArray = new int[(max - min) + 1];

        for (int k : input) {
            countingArray[k - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countingArray[i - min] > 0) {
                input[j++] = i;//+ 1;
                countingArray[i - min]--;
            }
        }

        System.out.print("opt: ");
        System.out.println(Arrays.toString(input));

    }

}
