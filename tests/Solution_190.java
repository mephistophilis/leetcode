package tests;
//190. Reverse Bits

//https://leetcode.com/problems/reverse-bits/

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
        Assertions.assertEquals(reverseBits((int) Long.parseLong("00000010100101000001111010011100",
        2)),
        (int) Long.parseLong("00111001011110000010100101000000", 2));

        Assertions.assertEquals(reverseBits((int) Long.parseLong("11111111111111111111111111111101", 2)),
                (int) Long.parseLong("10111111111111111111111111111111", 2));
    }
}