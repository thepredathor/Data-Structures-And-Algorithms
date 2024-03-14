
package algorithms.recursion.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class CoinGame {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println(coinGame("you", 4));
        System.out.println(coinGameOptimized("you", 4));
        System.out.println(coinGameFurtherOptimized(4));
    }

    public static String coinGame(String currentPlayer, int noOfCoins) {
        String nextPlayer;
        if ("you".equals(currentPlayer)) {
            nextPlayer = "them";
        } else {
            nextPlayer = "you";
        }

        if (noOfCoins <= 0) {
            return currentPlayer;
        }

        if (currentPlayer.equals(coinGame(nextPlayer, noOfCoins - 1)) || currentPlayer.equals(coinGame(nextPlayer, noOfCoins - 2))) {
            return currentPlayer;
        }

        return nextPlayer;
    }

    public static String coinGameOptimized(String currentPlayer, int noOfCoins) {
        return coinGameOptimized(currentPlayer, noOfCoins, new HashMap<>());
    }

    public static String coinGameOptimized(String currentPlayer, int noOfCoins, Map<PlayerNoOfCoinsPair, String> memoTable) {
        String nextPlayer;
        if ("you".equals(currentPlayer)) {
            nextPlayer = "them";
        } else {
            nextPlayer = "you";
        }
        if (noOfCoins <= 0) {
            return currentPlayer;
        }

        PlayerNoOfCoinsPair previousRound = new PlayerNoOfCoinsPair(nextPlayer, noOfCoins - 1);
        PlayerNoOfCoinsPair previousSecondRound = new PlayerNoOfCoinsPair(nextPlayer, noOfCoins - 2);
        if (memoTable.get(previousRound) == null) {
            memoTable.put(previousRound, coinGameOptimized(nextPlayer, noOfCoins - 1, memoTable));
        }
        if (memoTable.get(previousSecondRound) == null) {
            memoTable.put(previousSecondRound, coinGameOptimized(nextPlayer, noOfCoins - 2, memoTable));
        }

        if (currentPlayer.equals(memoTable.get(previousRound)) || currentPlayer.equals(memoTable.get(previousSecondRound))) {
            return currentPlayer;
        }
        return nextPlayer;
    }

    public static String coinGameFurtherOptimized(int noOfCoins) {
        if (((noOfCoins - 1) % 3) == 0) {
            return "them";
        }

        return "you";
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Nested Classes 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static class PlayerNoOfCoinsPair {
        String currentPlayer;
        int noOfCoins;

        public PlayerNoOfCoinsPair(String currentPlayer, int noOfCoins) {
            this.currentPlayer = currentPlayer;
            this.noOfCoins = noOfCoins;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if ((o == null) || (getClass() != o.getClass()))
                return false;
            PlayerNoOfCoinsPair that = (PlayerNoOfCoinsPair) o;
            return (noOfCoins == that.noOfCoins) && Objects.equals(currentPlayer, that.currentPlayer);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currentPlayer, noOfCoins);
        }
    }
}
