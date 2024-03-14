
package blind75.array;

public class MaximumProductSubArray {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    //Given an integer array nums, find a
    //subarray
    // that has the largest product, and return the product.
    //
    //The test cases are generated so that the answer will fit in a 32-bit integer.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [2,3,-2,4]
    //Output: 6
    //Explanation: [2,3] has the largest product 6.
    //Example 2:
    //
    //Input: nums = [-2,0,-1]
    //Output: 0
    //Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

    public static void main(String[] args) {
        int[] ints = { 2, 3, -2, 4 };
        int[] ints2 = { -2, 0, -1 };
        int[] ints3 = { -2, 3, -4 };
        int[] ints4 = { -2, 3, 6, -4 };
        int[] ints5 = { -2, 3, 6, -4, -2 };
        int[] ints6 = { -2, -3, 6, -4 };

        System.out.println(maxProduct(ints));
        System.out.println(maxProduct(ints2));
        System.out.println(maxProduct(ints3));
        System.out.println(maxProduct(ints4));
        System.out.println(maxProduct(ints5));
        System.out.println(maxProduct(ints6));
    }

    public static int maxProduct(int[] nums) {
        int countNegativeNumbers = 0;
        for (int num : nums) {
            if (num < 0) {
                countNegativeNumbers++;
            }
        }

        int currentProduct = 1;
        int secondCountNegativeNumbers = 0;

        if ((countNegativeNumbers % 2) == 0) {
            for (int num : nums) {
                currentProduct *= num;
            }
        } else {
            for (int num : nums) {
                if (secondCountNegativeNumbers < countNegativeNumbers) {
                    currentProduct *= num;
                    secondCountNegativeNumbers++;
                }
            }
        }

        return 0;
    }
}
