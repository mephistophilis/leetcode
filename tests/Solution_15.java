package tests;
//15. 3Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);

        for (int idx = 0; idx < nums.length - 2; idx++) {
            if (idx > 0 && nums[idx] == nums[idx - 1]) {
                continue;
            }

            int jdx = idx + 1;
            int kdx = nums.length - 1;

            while (jdx < kdx) {
                int sum = nums[idx] + nums[jdx] + nums[kdx];

                if (sum > 0) {
                    kdx -= 1;
                } else if (sum < 0) {
                    jdx += 1;
                } else {
                    lists.add(Arrays.asList(nums[idx], nums[jdx], nums[kdx]));
                    while (jdx < kdx && nums[jdx] == nums[jdx + 1]) {
                        jdx += 1;
                    }

                    while (jdx < kdx && nums[kdx] == nums[kdx - 1]) {
                        kdx -= 1;
                    }
                    jdx += 1;
                    kdx -= 1;
                }

            }

        }

        return lists;
    }

    @Test
    void test() {
        Assertions.assertEquals(
                threeSum(TestHelper.arrayStringToIntArray("[-1,0,1,2,-1,-4]")),
                (TestHelper.array2DStringToIntList("[[-1,-1,2],[-1,0,1]]")));

        Assertions.assertEquals(
                TestHelper.array2DStringToIntList("[]"),
                threeSum(TestHelper.arrayStringToIntArray("[]")));

        Assertions.assertEquals(
                threeSum(TestHelper.arrayStringToIntArray("[0]")),
                (TestHelper.array2DStringToIntList("[]")));
    }
}