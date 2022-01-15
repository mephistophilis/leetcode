package tests;
//90. Subsets II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_78 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }

    private void subsetsHelper(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int start) {
        result.add(new ArrayList<Integer>(list));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsHelper(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    @Test
    void test() {
        Assertions
                .assertEquals(
                        subsetsWithDup(TestHelper.arrayStringToIntArray("[1,2,2]")),
                        TestHelper.array2DStringToIntList("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]"));

    }
}