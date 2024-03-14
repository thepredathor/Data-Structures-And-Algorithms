
package algorithms.greedy;

public class StockPredictions {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        double[] doubles = { 22, 25, 21, 18, 19.6, 17, 16, 20.5 };
        double[] doubles2 = { 9, 7, 8, 6, 5, 1, 2 };
        double[] doubles3 = { 5, 2, 8, 4, 3, 7 };
        double[] doubles4 = { 8, 9, 7, 10 };
        System.out.println(isTrendUpward(doubles));
        System.out.println(isTrendUpward(doubles2));
        System.out.println(isTrendUpward(doubles3));
        System.out.println(isTrendUpward(doubles4));
    }

    public static boolean isTrendUpward(double[] stocksArray) {
        double firstStock = stocksArray[0];
        double secondStock = Double.POSITIVE_INFINITY;
        for (double n : stocksArray) {
            if (n < firstStock) {
                firstStock = n;
            } else if ((n > firstStock) && (n < secondStock)) {
                secondStock = n;
            } else if ((n > firstStock) && (n > secondStock)) {
                return true;
            }
        }

        return false;
    }
}
