
package blind75.binary;

public class NumberOfOneBits {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int n1 = 0b00000000000000000000000000001011;
        int n2 = 0b00000000000000000000000010000000;
        int n3 = 0b11111111111111111111111111111101;

//        System.out.println(hammingWeight(n1));
//        System.out.println(hammingWeight(n2));
        System.out.println(hammingWeight(n3));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        int passes = 0;
        int mask = 1;
        while (passes != 32) {
            if ((n & mask) == 1) {
                count++;
            }
            n = n >> 1;
            passes++;
        }

        return count;
    }
}
