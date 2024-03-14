
package algorithms.dynamic_programming.memoization.problems;

import java.util.HashMap;
import java.util.Map;


public class FibonacciSequence {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Display the fib sequence given the nth number using dynamic programming memoization (hash tables)
    // Eg: n = 8 => 21
    public static void main(String[] args) {
        System.out.println(fib(7));
    }

    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public static int fib(int n, Map<Integer, Integer> memoizationTable) {
        if ((n == 1) || (n == 0)) { // base cases: n=0 or n=1 will return themselves
            return n;
        }

        if (memoizationTable.get(n) == null) { // we verify the memo table to see if a value is stored for n
            memoizationTable.put(n, fib(n - 1, memoizationTable) + fib(n - 2, memoizationTable));
            // we put in the memo table the value associated
            // to the current n (key) for future computations
            // the value is recursive call with previous no plus recursive call to the second previous no
        }

        return memoizationTable.get(n); // return the value if the memo table contains it
    }
}
