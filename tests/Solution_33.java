package tests;
//33. Search in Rotated Sorted Array

//https://leetcode.com/problems/search-in-rotated-sorted-array/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int num = nums[mid];

            if (!((nums[mid] < nums[0]) ^ (target < nums[0]))) {

            } else {
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (num == target) {
                return mid;
            } else if (num < target) {
                l = mid + 1;
            } else if (num > target) {
                r = mid - 1;
            }
        }

        return -1;
    }

    @Test
    void test() {
        Assertions.assertEquals(search(TestHelper.arrayStringToIntArray("[4,5,6,7,0,1,2]"),
                0),
                4);

        Assertions.assertEquals(search(TestHelper.arrayStringToIntArray("[4,5,6,7,0,1,2]"),
                3),
                -1);

        Assertions.assertEquals(search(TestHelper.arrayStringToIntArray("[1]"),
                0),
                -1);
        Assertions.assertEquals(search(TestHelper.arrayStringToIntArray("[1]"),
                1),
                0);
        Assertions.assertEquals(search(TestHelper.arrayStringToIntArray("[1,3]"),
                3),
                1);
    }
}