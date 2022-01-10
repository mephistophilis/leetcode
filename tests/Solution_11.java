package tests;
//986. Interval List Intersections

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/interval-list-intersections/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_11 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
    
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
    
        return maxArea;
    }

    @Test
    void test() {
        Assertions
                .assertEquals(
                    maxArea(TestHelper.arrayStringToIntArray("[1,8,6,2,5,4,8,3,7]")),49);

    }
}