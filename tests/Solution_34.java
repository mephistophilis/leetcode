package tests;
//34. Find First and Last Position of Element in Sorted Array

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[] { -1, -1 };
        if (nums == null || nums.length == 0) {
            return ret;
        }

        ret[0] = findFirst(nums, target, 0, nums.length - 1);
        ret[1] = findLast(nums, target, ret[0], nums.length - 1);

        return ret;
    }

    int findFirst(int[] nums, int target, int l, int r) {
        int ret = -1;
        if (nums == null || nums.length == 0) {
            return ret;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                l = mid + 1;

            } else {
                r = mid;
            }
        }

        if (nums[l] == target) {
            ret = l;
        }

        return ret;
    }

    int findLast(int[] nums, int target, int l, int r) {
        int ret = -1;
        if (nums == null || nums.length == 0 || l == -1) {
            return ret;
        }

        while (l < r) {
            int mid = l + (r - l + 1) / 2;

            if (nums[mid] > target) {
                r = mid - 1;

            } else {
                l = mid;
            }

        }
        if (nums[r] == target) {
            ret = r;
        }

        return ret;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(searchRange(TestHelper.arrayStringToIntArray("[5,7,7,8,8,10]"),
                8),
                TestHelper.arrayStringToIntArray("[3,4]"));

        Assertions.assertArrayEquals(searchRange(TestHelper.arrayStringToIntArray("[5,7,7,8,8,10]"),
                6),
                TestHelper.arrayStringToIntArray("[-1,-1]"));

        Assertions.assertArrayEquals(searchRange(TestHelper.arrayStringToIntArray("[]"),
                0),
                TestHelper.arrayStringToIntArray("[-1,-1]"));

        Assertions.assertArrayEquals(searchRange(TestHelper.arrayStringToIntArray("[1]"),
                1),
                TestHelper.arrayStringToIntArray("[0,0]"));

        Assertions.assertArrayEquals(searchRange(TestHelper.arrayStringToIntArray("[1]"),
                0),
                TestHelper.arrayStringToIntArray("[-1,-1]"));

        Assertions.assertArrayEquals(searchRange(TestHelper.arrayStringToIntArray("[-1]"), 0),
                TestHelper.arrayStringToIntArray("[-1,-1]"));
    }
}