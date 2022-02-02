package tests;
//69. Sqrt(x)

//https://leetcode.com/problems/sqrtx/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_69 {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x /mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }

    @Test
    void test() {
        Assertions.assertEquals(46339, mySqrt(2147395599));
    }
}