package blind75.dynamic_programming;

import java.util.HashMap;

public class ClimbingStairs {
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    public int climbStairs(int n, HashMap<Integer, Integer> visited) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (visited.get(n) != null) {
            return visited.get(n);
        }

        visited.put(n, climbStairs(n - 1, visited) + climbStairs(n - 2, visited));

        return visited.get(n);
    }
}
