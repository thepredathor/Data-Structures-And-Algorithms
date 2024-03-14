
package blind75.array;

import java.util.Arrays;


public class SearchInRotatedSortedArray {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    //There is an integer array nums sorted in ascending order (with distinct values).
    //
    //Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    //
    //Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
    //
    //You must write an algorithm with O(log n) runtime complexity.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [4,5,6,7,0,1,2], target = 0
    //Output: 4
    //Example 2:
    //
    //Input: nums = [4,5,6,7,0,1,2], target = 3
    //Output: -1
    //Example 3:
    //
    //Input: nums = [1], target = 0
    //Output: -1
    //
    //
    //Constraints:
    //
    //1 <= nums.length <= 5000
    //-104 <= nums[i] <= 104
    //All values of nums are unique.
    //nums is an ascending array that is possibly rotated.
    //-104 <= target <= 104

    public static void main(String[] args) {
        int[] ints = { 4, 5, 6, 7, 0, 1, 2 };
        int[] ints2 = { 4, 5, 6, 7, 0, 1, 2 };
        int[] ints3 = { 1 };
        int[] ints4 = { 1, 3, 5 };
        int[] ints5 = { 1, 3 };
        int[] ints6 = { 1, 3, 5 };
        int[] ints7 = { 2, 3, 4, 5, 6, 7, 8, 9, 1 };

//        System.out.println(search(ints, 0));
//        System.out.println(search(ints2, 3));
//        System.out.println(search(ints3, 0));
//        System.out.println(search(ints4, 5));
//        System.out.println(search(ints5, 3));
//        System.out.println(search(ints6, 4));
//        System.out.println(search(ints7, 9));
        System.out.println(searchCorrect(ints3, 1));
    }

    public static int searchCorrect(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left != right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] < nums[mid]) {
                if ((nums[left] <= target) && (target < nums[mid])) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if ((nums[mid] < target) && (target <= nums[right - 1])) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

        }

        return -1;
    }
}
