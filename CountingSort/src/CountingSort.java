import java.util.Arrays;

/**
 * @Created: 20/06/2022
 * @author: hasan.khan
 */
public class CountingSort {
    public static void main(String[] args) {

       // int[] input = {10, 7, 8, 10, 6, 8, 5, 10, 1, 8};
        int[] input =   Utils.generateArrayWithRandomNumber(10, 1, 10);
        System.out.println(Arrays.toString(input));
        countingSort(input);

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
            if (count != 0) {
                while (count > 0) {
                    test[j] = i + 1;
                    count--;
                    j++;
                }
            }
        }

        System.out.println(Arrays.toString(test));

    }

}
