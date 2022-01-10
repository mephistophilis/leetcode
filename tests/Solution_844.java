package tests;
//844. Backspace String Compare

//https://leetcode.com/problems/two-sum/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_844 {

    public boolean backspaceCompare(String s, String t) {
        int sdx = s.length() - 1;
        int tdx = t.length() - 1;

        int sCount = 0;
        int tCount = 0;
        while (sdx >= -1 && tdx >= -1) {
            while (sdx >= 0 && (sCount > 0 || s.charAt(sdx) == '#')) {
                if (s.charAt(sdx) == '#') {
                    sCount++;
                } else {
                    sCount--;
                }

                sdx--;
            }

            char l = sdx < 0 ? '@' : s.charAt(sdx);

            while (tdx >= 0 && (tCount > 0 || t.charAt(tdx) == '#')) {
                if (t.charAt(tdx) == '#') {
                    tCount++;
                } else {
                    tCount--;
                }

                tdx--;
            }

            char r = tdx < 0 ? '@' : t.charAt(tdx);

            if (l != r) {
                return false;
            }

            sdx--;
            tdx--;
        }

        return true;
    }

    @Test
    void test() {
        Assertions.assertFalse(backspaceCompare("bbbextm","bbb#extm"));
        Assertions.assertTrue(backspaceCompare("ab#c", "ad#c"));
        Assertions.assertTrue(backspaceCompare("ab##", "c#d#"));
        Assertions.assertFalse(backspaceCompare("a#c", "b"));
    }
}