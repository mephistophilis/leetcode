package tests;
//190. Reverse Bits

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n = n >> 1;
            ret = ((ret << 1) | bit);
        }

        return ret;
    }

    @Test
    void test() {
        Assertions.assertEquals(reverseBits(Integer.parseInt("00000010100101000001111010011100", 2)),
                Integer.parseInt("00111001011110000010100101000000", 2));

        Assertions.assertEquals(reverseBits(Integer.parseInt("11111111111111111111111111111101", 2)),
                Integer.parseInt("10111111111111111111111111111111", 2));
    }
}