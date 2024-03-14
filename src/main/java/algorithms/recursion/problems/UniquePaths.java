
package algorithms.recursion.problems;

public class UniquePaths {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem: given a table of n rows and m columns a starting position in the top left corner and finishing position in the bottom right corner
    // being able to move one square down or right at a time => find the number of unique paths from start to finish
    // Eg: rows = 3, columns = 7 => 28
    // Eg2: rows = 2, columns = 2 => 2
    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2));
    }

    public static int uniquePaths(int rows, int columns) {
        if ((rows == 1) || (columns == 1)) {
            return 1;
        }

        return uniquePaths(rows - 1, columns) + uniquePaths(rows, columns - 1);
    }
}
