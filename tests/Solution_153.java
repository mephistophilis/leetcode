package tests;
//153. Find Minimum in Rotated Sorted Array

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }

    @Test
    void test() {
        Assertions.assertEquals(
                findMin(TestHelper.arrayStringToIntArray("[3,4,5,1,2]")),
                1);
        Assertions.assertEquals(
                findMin(TestHelper.arrayStringToIntArray("[4,5,6,7,0,1,2]")),
                0);

        Assertions.assertEquals(
                findMin(TestHelper.arrayStringToIntArray("[11,13,15,17]")),
                11);
    }
}