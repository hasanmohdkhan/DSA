import java.util.Date;

public class BubbleSortApplication {

    public static void main(String[] args) {


        int[] intArr = {20,35,-15,1,-22, -1, 100 ,3,1,0,60,12,1,-22, -1,90};

        long startTime = System.currentTimeMillis();
        //traversing array in desc order i.e. from last index to first
        for(int lastSortIndex = intArr.length -1 ; lastSortIndex > 0 ; lastSortIndex--){

            //traversing arr in sorted partition from index 0 to lastSort index
            for (int i = 0; i < lastSortIndex; i++) {
                //checking if value is greater on index i from i+1
                if(intArr[i] > intArr[i+1]){
                    swap(intArr,i , i +1);
                }
            }

        }

        long stopTime = System.currentTimeMillis();

        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
        System.out.println("Time: " +(stopTime - startTime) + " nanoSec");

    }

    /**
     * method to swap the two value
     *
     * @param arr array
     * @param i   index n
     * @param j   index n+1
     */
    public static void swap(int[] arr, int i, int j) {
        //both are equal no swap required
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
}
