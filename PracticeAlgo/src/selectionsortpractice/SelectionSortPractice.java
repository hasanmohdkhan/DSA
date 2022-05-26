package selectionsortpractice;

/**
 * @Created: 26/05/2022
 * @author: hasan.khan
 */
public class SelectionSortPractice {

    public static void main(String[] args) {

        int worstCase10L = 1000000;
        int[] arrayWithRandomNumber = Utils.generateArrayWithRandomNumber(worstCase10L);
        long startTime = System.currentTimeMillis();
        selectionSort(arrayWithRandomNumber);
        long endTime = System.currentTimeMillis();
        Utils.time(startTime,endTime);
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
}
