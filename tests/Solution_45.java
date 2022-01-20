package tests;
//45. Jump Game II

//https://leetcode.com/problems/jump-game/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_45 {
    public int jump(int[] nums) {
        int jumps = 0, farthest = 0;
        int left = 0, right = 0;
        while (right < nums.length - 1) {
            for (int i = left; i <= right; ++i)
                farthest = Math.max(farthest, i + nums[i]);
            left = right + 1;
            right = farthest;
            ++jumps;
        }
        return jumps;
    }

    @Test
    void test() {
        Assertions.assertEquals(2,
                jump(TestHelper.arrayStringToIntArray("[2,3,1,1,4]")));
    }
}