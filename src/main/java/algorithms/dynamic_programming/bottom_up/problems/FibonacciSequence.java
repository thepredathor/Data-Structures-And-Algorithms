
package algorithms.dynamic_programming.bottom_up.problems;

public class FibonacciSequence {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Display the fib sequence using a bottom up dynamic programming approach given the nth element in the sequence
    // (without recursion)
    // Eg: n = 7 => 13
    public static void main(String[] args) {
        System.out.println(fib(8));
    }

    public static int fib(int n) {
        if ((n == 1) || (n == 0)) { // first 2 numbers are hardcoded
            return n;
        }

        int first = 0; // we start from the first number which is 0
        int second = 1; // the second no in the sequence is 1
        for (int i = 1; i < n; i++) { // we iterate from 1 to n
            int currNo = first + second; // we add up the previous 2 numbers and store them in a current no
            first = second; // the first number moves to the second number
            second = currNo; // the second number becomes the current computed number
        }

        return second; // we print the second number which will become the nth number in the sequence
    }
}
