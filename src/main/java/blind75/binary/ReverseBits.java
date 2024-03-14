
package blind75.binary;

public class ReverseBits {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        System.out.println(Integer.toBinaryString(reverseBits(n)));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int lastBit = n & 1;
            result = result | (lastBit << (31 - i));
            n >>= 1;
        }

        return result;
    }
}
