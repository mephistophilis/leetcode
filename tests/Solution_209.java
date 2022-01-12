package tests;
//209. Minimum Size Subarray Sum

//https://leetcode.com/problems/minimum-size-subarray-sum/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_209 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= target) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    @Test
    void test() {
        Assertions
                .assertEquals(2, minSubArrayLen(7, TestHelper.arrayStringToIntArray("[2,3,1,2,4,3]")));

    }
}