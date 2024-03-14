
package algorithms.greedy;

public class GreatestSubsectionSum {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] ints = { 3, -4, 4, -3, 5, -9 };
        System.out.println(findGreatestSubsectionSum(ints));
    }

    public static int findGreatestSubsectionSum(int[] array) {
        int greatestSum = 0;
        int currentSum = 0;

        for (int n : array) {
            if ((currentSum + n) < 0) {
                currentSum = 0;
            } else {
                currentSum += n;
                if (currentSum > greatestSum) {
                    greatestSum = currentSum;
                }
            }
        }

        return greatestSum;
    }
}
