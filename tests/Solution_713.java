package tests;
//713. Subarray Product Less Than K

//https://leetcode.com/problems/subarray-product-less-than-k/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0)
            return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }

    @Test
    void test() {
        Assertions
                .assertEquals(8, numSubarrayProductLessThanK(TestHelper.arrayStringToIntArray("[10,5,2,6]"), 100));

    }
}