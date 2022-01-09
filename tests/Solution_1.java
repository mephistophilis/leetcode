package tests;
//1. Two Sum

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(
                twoSum(TestHelper.arrayStringToIntArray("[3,2,4]"), 6),
                (TestHelper.arrayStringToIntArray("[1,2]")));

        Assertions.assertArrayEquals(
                twoSum(TestHelper.arrayStringToIntArray("[2,7,11,15]"), 9),
                (TestHelper.arrayStringToIntArray("[0,1]")));
    }
}