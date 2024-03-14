
package algorithms.recursion.problems;

public class StaircaseProblem {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Given you cam climb 1, 2 or 3 steps at a time, how many ways are there to climb to the top of the nth step
    // Eg: n = 3 => 4
    // Eg: n = 4 => 7
    // Eg: n = 5 => 13
    // n = 5 = [1,1,1,1,1], [1,1,1,2], [1,1,2,1], [1,2,1,1], [2,1,1,1], [1,1,3], [1,3,1], [3,1,1], [2,3], [3,2], [1,2,2], [2,1,2], [2,2,1]
    // n = 4 = [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2], [1,3], [3,1] = 7
    // n = 3 = [1,1,1], [1,2], [2,1], [3] = 4
    // n = 2 = [1,1], [2] = 2
    // n = 1 = [1] = 1
    // n = 0 = 1
    public static void main(String[] args) {
        System.out.println(getNumberOfPossibleWaysToClimb(3));
        System.out.println(getNumberOfPossibleWaysToClimb(4));
        System.out.println(getNumberOfPossibleWaysToClimb(5));
    }

    public static int getNumberOfPossibleWaysToClimb(int n) {
        if (n < 0) {
            return 0; // base case 1: if n < 0 than no of paths is 0
        }
        if ((n == 1) || (n == 0)) { // base case 2: if n == 1 or n == 0 than no of paths is 1, for 0 we assume to be 1 just to help with calculation
            return 1;
        }
        return getNumberOfPossibleWaysToClimb(n - 1) + getNumberOfPossibleWaysToClimb(n - 2) + getNumberOfPossibleWaysToClimb(n - 3); // solution: return sum of no of paths for the previous 3 iterations
    }
}
