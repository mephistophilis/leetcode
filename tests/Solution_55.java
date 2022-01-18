package tests;
//55. Jump Game

//https://leetcode.com/problems/jump-game/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;

        if (len < 1) {
            return false;
        }

        int lastpos = len - 1;

        for (int i = len - 1; i >= 0; i--) {
            if (i + nums[i] >= lastpos) {
                lastpos = i;
            }
        }
        return lastpos == 0;
    }

    @Test
    void test() {
        Assertions.assertTrue(
                canJump(TestHelper.arrayStringToIntArray("[2,3,1,1,4]")));
    }
}