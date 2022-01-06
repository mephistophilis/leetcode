package tests;
//704. Binary Search
//https://leetcode.com/problems/binary-search/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_704 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int ret = -1;
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int mid = l+(r-l)/2;
            if(nums[mid] == target) {
                ret = mid;
                break;
            }
            else if(nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return ret;
    }

    @Test
    void test() {
        Assertions.assertEquals(search(TestHelper.arrayStringToIntArray("[-1,0,3,5,9,12]"), 9),
                4);
        Assertions.assertEquals(search(TestHelper.arrayStringToIntArray("[-1,0,3,5,9,12]"), 2),
                -1);
        Assertions.assertEquals(search(TestHelper.arrayStringToIntArray("[5]"), 5),
                0);
    }
}