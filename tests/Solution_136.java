package tests;
//136. Single Number

//https://leetcode.com/problems/single-number/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.ListNode;
import tests.common.TestHelper;

class Solution_136 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        return ret;
    }

    @Test
    void test() {
        Assertions.assertEquals(singleNumber(TestHelper.arrayStringToIntArray("[2,2,1]")),
                1);
        Assertions.assertEquals(singleNumber(TestHelper.arrayStringToIntArray("[4,1,2,1,2]")),
                4);
        Assertions.assertEquals(singleNumber(TestHelper.arrayStringToIntArray("[1]")),
                1);
    }
}