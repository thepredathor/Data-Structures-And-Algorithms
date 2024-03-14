
package algorithms.dynamic_programming.memoization.problems;

import java.util.HashMap;
import java.util.Objects;


public class UniquePaths {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Given the unique paths algorithm, make it efficient with memoization

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int rows, int columns, HashMap<UniquePathsKey, Integer> memoizationTable) {
        if ((rows == 1) || (columns == 1)) {
            return 1;
        }

        if (memoizationTable.get(new UniquePathsKey(rows, columns)) == null) {
            memoizationTable.put(new UniquePathsKey(rows, columns), uniquePaths(rows - 1, columns, memoizationTable) + uniquePaths(rows, columns - 1, memoizationTable));
        }

        return memoizationTable.get(new UniquePathsKey(rows, columns));
    }

    public static int uniquePaths(int rows, int columns) {
        return uniquePaths(rows, columns, new HashMap<>());
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Nested Classes 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static class UniquePathsKey {
        int rows, columns;

        public UniquePathsKey(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if ((o == null) || (getClass() != o.getClass()))
                return false;
            UniquePathsKey that = (UniquePathsKey) o;
            return (rows == that.rows) && (columns == that.columns);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rows, columns);
        }
    }
}
