
package blind75.array;

import java.util.HashMap;


public class ContainsDuplicate {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    //Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,2,3,1]
    //Output: true
    //Example 2:
    //
    //Input: nums = [1,2,3,4]
    //Output: false
    //Example 3:
    //
    //Input: nums = [1,1,1,3,3,4,3,2,4,2]
    //Output: true
    //
    //
    //Constraints:
    //
    //1 <= nums.length <= 105
    //-109 <= nums[i] <= 109

    public static void main(String[] args) {
        int[] ints = { 1, 2, 3, 1 };
        int[] ints2 = { 1, 2, 3, 4 };
        int[] ints3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println(containsDuplicate(ints));
        System.out.println(containsDuplicate(ints2));
        System.out.println(containsDuplicate(ints3));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> integerOccurencesMap = new HashMap<>();
        for (int num : nums) {
            if (integerOccurencesMap.putIfAbsent(num, false) != null) {
                return true;
            }
        }

        return false;
    }
}
