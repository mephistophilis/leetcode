package tests;
//35. Search Insert Position

//https://leetcode.com/problems/search-insert-position/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r + 1;
    }

    @Test
    void test() {
        Assertions.assertEquals(0, searchInsert(TestHelper.arrayStringToIntArray("[1,3,5,6]"),
                0));
    }
}