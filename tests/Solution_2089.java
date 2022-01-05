package tests;
//2089. Find Target Indices After Sorting Array

//https://leetcode.com/problems/find-target-indices-after-sorting-array/

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        
        int lessThanTarget = 0;
        int eqToTarget = 0;
        for(int num : nums) {
            if(num == target) {
                eqToTarget+=1;
            } else if(num < target) {
                lessThanTarget+=1;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < eqToTarget; i++) {
            result.add(lessThanTarget++);
        }
        
        return result;
    }

    @Test
    void test() {
        Assertions.assertEquals(
                targetIndices(new int[] { 1, 2, 5, 2, 3 }, 2), new ArrayList<Integer>() {
                    {
                        add(1);
                        add(2);
                    }
                });

        Assertions.assertEquals(
                targetIndices(new int[] { 1, 2, 5, 2, 3 }, 3), new ArrayList<Integer>() {
                    {
                        add(3);
                    }
                });

        Assertions.assertEquals(
                targetIndices(new int[] { 1, 2, 5, 2, 3 }, 5), new ArrayList<Integer>() {
                    {
                        add(4);
                    }
                });

    }
}