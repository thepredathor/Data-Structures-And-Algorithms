
package blind75.array;

public class MajorityElement {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] ints = { 3, 2, 3 };
        int[] ints2 = { 2, 2, 1, 1, 1, 2, 2 };
        int[] ints3 = { 10, 9, 9, 9, 10 };
        int[] ints4 = { 1 };
        System.out.println(majorityElement(ints));
        System.out.println(majorityElement(ints2));
        System.out.println(majorityElement(ints3));
        System.out.println(majorityElementSecond(ints));
        System.out.println(majorityElementSecond(ints2));
        System.out.println(majorityElementSecond(ints3));
        System.out.println(majorityElementSecond(ints4));
    }

    public static int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }
        if (majorityCount > (nums.length / 2)) {
            return majorityElement;
        }
        majorityElement = nums[nums.length - 1];
        majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }
        if (majorityCount > (nums.length / 2)) {
            return majorityElement;
        }
        majorityElement = nums[nums.length / 2];
        majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }

        return majorityElement;
    }

    public static int majorityElementSecond(int[] nums) {
        int first = nums[0];
        int mid = nums[nums.length / 2];
        int midPlusOne = (((nums.length / 2) + 1) > (nums.length - 1)) ? nums[nums.length - 1] : nums[(nums.length / 2) + 1];
        int midMinusOne = (((nums.length / 2) - 1) < 0) ? nums[0] : nums[(nums.length / 2) - 1];
        int last = nums[nums.length - 1];

        int majorityElement = first;
        int majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }
        if (majorityCount > (nums.length / 2)) {
            return majorityElement;
        }
        majorityElement = mid;
        majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }
        if (majorityCount > (nums.length / 2)) {
            return majorityElement;
        }
        majorityElement = last;
        majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }
        if (majorityCount > (nums.length / 2)) {
            return majorityElement;
        }
        majorityElement = midPlusOne;
        majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }
        if (majorityCount > (nums.length / 2)) {
            return majorityElement;
        }
        majorityElement = midMinusOne;
        majorityCount = 0;
        for (int num : nums) {
            if (num == majorityElement) {
                majorityCount++;
            }
        }

        return majorityElement;
    }
}
