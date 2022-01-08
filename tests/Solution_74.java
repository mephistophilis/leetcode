package tests;
//74. Search a 2D Matrix

//https://leetcode.com/problems/search-a-2d-matrix/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (binarySearch(nums, target) == true) {
                return true;
            }
        }

        return false;
    }

    boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int l = 0;
        int r = nums.length - 1;

        if (target >= nums[l] && target <= nums[r]) {
            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }

    @Test
    void test() {
        Assertions.assertEquals(
                searchMatrix(TestHelper.arrayStringTo2DIntArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"),
                        3),
                true);

        Assertions.assertEquals(
                searchMatrix(TestHelper.arrayStringTo2DIntArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"),
                        13),
                false);
    }
}