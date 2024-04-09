package blind75.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);

        for (int coin : coins) {
            if (coin <= amount) {
                memo.put(coin, 1);
            }
        }

        int result = coinChange(coins, amount, memo);
        if (result != Integer.MAX_VALUE) {
            return result;
        }
        return -1;
    }

    public static int coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int minCoinsNeeded = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin <= amount) {
                int result = coinChange(coins, amount - coin, memo);
                minCoinsNeeded = Math.min(result, minCoinsNeeded);
            }
        }

        if (minCoinsNeeded != Integer.MAX_VALUE) {
            minCoinsNeeded += 1;
        }
        memo.put(amount, minCoinsNeeded);

        return minCoinsNeeded;
    }
}
