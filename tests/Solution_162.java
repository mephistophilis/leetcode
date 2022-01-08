package tests;
//162. Find Peak Element

//https://leetcode.com/problems/find-peak-element/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_162 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid1 = l + (r - l) / 2;
            int mid2 = mid1 + 1;

            if (nums[mid1] < nums[mid2]) {
                l = mid1+1;
            } else {
                r = mid1;
            }
        }

        return l;
    }

    @Test
    void test() {
        Assertions.assertEquals(
            findPeakElement(TestHelper.arrayStringToIntArray("[1,2,3,1]")),
                2);
        Assertions.assertEquals(
            findPeakElement(TestHelper.arrayStringToIntArray("[1,2,1,3,5,6,4]")),
                5);
    }
}