
package algorithms.greedy;

public class MaxArrayNumber {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] ints = { 2, 3, 1, 10, 12 };
        System.out.println(findMaxNumberFromArray(ints));
    }

    public static int findMaxNumberFromArray(int[] array) {
        int maxNumber = 0;
        for (int no : array) {
            if (no > maxNumber) {
                maxNumber = no;
            }
        }

        return maxNumber;
    }
}
