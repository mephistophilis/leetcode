package tests;
//2089. Find Target Indices After Sorting Array
//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_1351 {
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int y = n - 1;
        int m = grid[0].length;
        int x = 0;

        int count = 0;
        for (int y1 = y; y1 >= 0; y1--) {
            for (int x1 = x; x1 < m; x1++) {
                if (grid[y1][x1] < 0) {
                    x = x1;
                    count += (m - x);
                    break;
                }
            }
        }

        return count;
    }

    @Test
    void test() {
        Assertions.assertEquals(
                countNegatives(TestHelper.arrayStringTo2DIntArray("[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]")),
                8);

        Assertions.assertEquals(
                countNegatives(TestHelper.arrayStringTo2DIntArray("[[3,2],[1,0]]")),
                0);
    }
}