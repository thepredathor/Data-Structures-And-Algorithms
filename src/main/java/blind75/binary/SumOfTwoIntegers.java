
package blind75.binary;

public class SumOfTwoIntegers {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int a1 = 1;
        int b1 = 2;
        int a2 = 2;
        int b2 = 3;
        System.out.println(getSum(a1, b1));
        System.out.println(getSum(a2, b2));
    }

    public static int getSum(int a, int b) {
        int xorResult = a ^ b;
        int carry = (a & b) << 1;

        while (carry != 0) {
            int temp = xorResult;
            xorResult = xorResult ^ carry;
            carry = (temp & carry) << 1;
        }

        return xorResult;
    }
}
