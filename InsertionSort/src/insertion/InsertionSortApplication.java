package insertion;

/**
 * The Insertion sort
 *
 * - Assume that 0th position is sorted[in case of 1 element in array no need to do sorting/looping]
 *
 * - We start with 1st position on loop and goes to last of array
 *
 * - Then start new loop from unsorted array i.e. from firstUnsortedIndex to 0th position
 * - then replace value if i-1 is greater than ith position
 *
 *
 *
 */
public class InsertionSortApplication {


    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 1, -22, -1, 100, 3, 21, 10, 60, 12, 189, -6, -11, 90, 0};

        //Assume that 0th position is sorted[in case of 1 element in array no need to do sorting/looping]
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
           //backing up value in newElement
            int newElement = intArray[firstUnsortedIndex];

            // Declared here because we need it outside loop to replace value
            int i;

            // i > 0  => check for 1st position(intArray[0] is already sorted)
            // intArray[i - 1] > newElement => check that element at lower index is greater or not
            // example: on 2nd[-15] position  is less than 34 at 1st position
            // && if both are true then replace value 35 with -15
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            // restore value on ith position
            intArray[i] = newElement;

        }


        for (int j : intArray) {
            System.out.println(j);
        }
    }
}