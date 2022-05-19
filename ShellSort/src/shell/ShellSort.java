package shell;

/**
 * @Created: 19/05/2022
 * @author: hasan.khan
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22,/* 3, 21, 10, 60, 12, 189, -6, -11, 90, 0*/};

        /*
         * Diving array to half and on every iteration we are again dividing by half 'gap /= 2'
         * i.e. as array length is 7 it will be 3 and on next iteration 3/2 = 1
         */
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

            // just for checking
            System.out.println("gap :"+gap);
            System.out.println(intArray[gap] + " index : "+gap );

            // now we are traveling from half array index to array.length
            for (int i = gap; i < intArray.length; i++) {
                // keeping track for start element value
                int newElement = intArray[i];

                //store in new value
                int  j = i;

                // comparing is j>= gap i.e. for
                // j=3 and gap=3
                // intArray[3-3] = intArray[0]=> 20(1st element in array)
                // now comparing 20 (intArray[0]) > 7 (intArray[3])
               while (j>= gap && intArray[j-gap]> newElement){
                   //store lower value at start of array i.e. sort
                   intArray[j] = intArray[j-gap];
                   j-=gap;
               }

                intArray[j]= newElement;
            }


        }


        for (int j : intArray) {
            System.out.println(j);
        }
    }
}
