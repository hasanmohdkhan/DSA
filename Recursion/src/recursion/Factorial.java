package recursion;

/**
 * @Created: 20/05/2022
 * @author: hasan.khan
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(iterativeFactorial(3));
        System.out.println(recursionFactorial(3));
    }


    public static int recursionFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        //How actually does recursion work in this by stacking 3* (num -1 <- wait till it finishes execution )
        //  num <- calculate at last
        // first it will calculate  recursionFactorial (num - 1)
        // Example:
        // for num 3 -> if 3==0 return false. So, num value will be 3 and store in stack(array internally)
        // for each iteration it will be {3,2,1} -> then multiply all as -> 3*2*1
        return num * recursionFactorial(num - 1);

    }


    /**
     * factorial with simple iteration
     *
     * @param number given number
     * @return factorial of number
     */
    public static int iterativeFactorial(int number) {

        if (number == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;


    }
}

