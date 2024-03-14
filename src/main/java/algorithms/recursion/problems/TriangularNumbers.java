
package algorithms.recursion.problems;

public class TriangularNumbers {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // For a given n number find the n-th number in the sequence
    // Eg: n = 7 => 1,3,6,10,15,21,28(7th number)
    public static void main(String[] args) {
        System.out.println(getNumberInSequence(7));
    }

    public static int getNumberInSequence(int n) {
        if ((n == 0)) { // base case: if n == 0 (starting number in the sequence)
            return 0; // return 0
        }

        return n + getNumberInSequence(n - 1); // return n + recursive call of n - 1 => sum of current index plus the last number(sum of previous numbers)
    }
}
