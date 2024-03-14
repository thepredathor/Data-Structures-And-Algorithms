
package blind75.binary;

public class MissingNumber {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] ints = { 3, 0, 1 };
        int[] ints2 = { 0, 1 };
        int[] ints3 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println("normal");
        System.out.println(missingNumberNormal(ints));
        System.out.println(missingNumberNormal(ints2));
        System.out.println(missingNumberNormal(ints3));
        System.out.println("binary");
        System.out.println(missingNumberBinary(ints));
        System.out.println(missingNumberBinary(ints2));
        System.out.println(missingNumberBinary(ints3));
    }

    public static int missingNumberBinary(int[] nums) {
        int xorResult = 0;

        for (int num : nums) {
            xorResult ^= num;
        }
        for (int i = 0; i <= nums.length; i++) {
            xorResult ^= i;
        }

        return xorResult;
    }

    public static int missingNumberNormal(int[] nums) {
        int totalArraySum = (nums.length + 1) * nums.length / 2;
        int sumWithMissingNumber = 0;

        for (int num : nums) {
            sumWithMissingNumber += num;
        }

        return totalArraySum - sumWithMissingNumber;
    }
}
