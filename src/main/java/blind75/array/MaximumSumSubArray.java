
package blind75.array;

public class MaximumSumSubArray {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

//Given an integer array nums, find the
//subarray
// with the largest sum, and return its sum.
//
//
//
//Example 1:
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//Example 2:
//
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
//Example 3:
//
//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-104 <= nums[i] <= 104
//
//
//Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

    public static void main(String[] args) {
        int[] ints = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] ints2 = { 1 };
        int[] ints3 = { 5, 4, -1, 7, 8 };
        int[] ints4 = { -2, 1 };
        int[] ints5 = { -2, -1 };
        int[] ints6 = { 1, 2 };
        int[] ints7 = { -2, 1 };

//        System.out.println("First Method");
//        System.out.println(maxSubArray(ints));
//        System.out.println(maxSubArray(ints2));
//        System.out.println(maxSubArray(ints3));
//        System.out.println(maxSubArray(ints4));
//        System.out.println(maxSubArray(ints5));
//        System.out.println(maxSubArray(ints6));
//        System.out.println(maxSubArray(ints7));
//        System.out.println("Second Method");
        System.out.println(maxSubArray2CorrentOne(ints));
        System.out.println(maxSubArray2CorrentOne(ints2));
        System.out.println(maxSubArray2CorrentOne(ints3));
        System.out.println(maxSubArray2CorrentOne(ints4));
        System.out.println(maxSubArray2CorrentOne(ints5));
        System.out.println(maxSubArray2CorrentOne(ints6));
        System.out.println(maxSubArray2CorrentOne(ints7));
    }

    public static int maxSubArray(int[] nums) {
        int biggestSum = nums[0];
        int currentSum = nums[0];
        int previousSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currentNumber = nums[i];

            if (((currentSum + currentNumber) > previousSum) && (currentNumber <= (currentNumber + currentSum))) {
                currentSum += currentNumber;
            } else if (((currentSum + currentNumber) < previousSum) && ((i + 1) != nums.length) && ((currentSum + currentNumber + nums[i + 1]) > previousSum)) {
                currentSum += currentNumber;
            } else {
                currentSum = currentNumber;
            }

            if (currentSum > biggestSum) {
                biggestSum = currentSum;
            }
            previousSum = currentSum;
        }

        return biggestSum;
    }

    public static int maxSubArray2CorrentOne(int[] nums) {
        int currentSum = 0;
        int biggestSum = nums[0];
        for (int currentNumber : nums) {
            if (((currentSum + currentNumber) < 0) || (currentNumber > (currentSum + currentNumber))) {
                currentSum = currentNumber;
            } else {
                currentSum += currentNumber;
            }

            if (currentSum > biggestSum) {
                biggestSum = currentSum;
            }
        }

        return biggestSum;
    }
}
