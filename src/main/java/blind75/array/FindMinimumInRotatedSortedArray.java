
package blind75.array;

import java.util.Arrays;


public class FindMinimumInRotatedSortedArray {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    //
    //[4,5,6,7,0,1,2] if it was rotated 4 times.
    //[0,1,2,4,5,6,7] if it was rotated 7 times.
    //Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
    //
    //Given the sorted rotated array nums of unique elements, return the minimum element of this array.
    //
    //You must write an algorithm that runs in O(log n) time.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [3,4,5,1,2]
    //Output: 1
    //Explanation: The original array was [1,2,3,4,5] rotated 3 times.
    //Example 2:
    //
    //Input: nums = [4,5,6,7,0,1,2]
    //Output: 0
    //Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
    //Example 3:
    //
    //Input: nums = [11,13,15,17]
    //Output: 11
    //Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

    public static void main(String[] args) {
        int[] ints = { 4, 5, 6, 7, 0, 1, 2 };
        int[] ints2 = { 0, 1, 2, 4, 5, 6, 7 };
        int[] ints3 = { 11, 13, 15, 17 };
        int[] ints4 = { 2, 1 };
        System.out.println(findMin(ints));
        System.out.println(findMin(ints2));
        System.out.println(findMin(ints3));
        System.out.println(findMin(ints4));
    }

    public static int findMin(int[] nums) {
        int firstElement = nums[0];
        int middleElement = nums[nums.length / 2];
        int lastElement = nums[nums.length - 1];

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        if ((firstElement > lastElement) && (lastElement > middleElement)) {
            return findMin(Arrays.copyOfRange(nums, 0, (nums.length / 2) + 1));
        } else if ((middleElement > firstElement) && (firstElement > lastElement)) {
            return findMin(Arrays.copyOfRange(nums, (nums.length / 2) + 1, nums.length));
        }

        return nums[0];
    }

}
