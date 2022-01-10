package tests;
//986. Interval List Intersections

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/interval-list-intersections/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0)
            return new int[0][0];
        int i = 0;
        int j = 0;
        int startMax = 0, endMin = 0;
        List<int[]> ans = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            startMax = Math.max(firstList[i][0], secondList[j][0]);
            endMin = Math.min(firstList[i][1], secondList[j][1]);

            if (endMin >= startMax) {
                ans.add(new int[] { startMax, endMin });
            }

            if (endMin == firstList[i][1])
                i++;
            if (endMin == secondList[j][1])
                j++;
        }

        return ans.toArray(new int[ans.size()][2]);
    }

    @Test
    void test() {
        Assertions
                .assertArrayEquals(
                        intervalIntersection(TestHelper.arrayStringTo2DIntArray("[[0,2],[5,10],[13,23],[24,25]]"),
                                TestHelper.arrayStringTo2DIntArray("[[1,5],[8,12],[15,24],[25,26]]")),
                        TestHelper.arrayStringTo2DIntArray("[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]"));

        Assertions
                .assertArrayEquals(
                        intervalIntersection(TestHelper.arrayStringTo2DIntArray("[[1,3],[5,9]]"),
                                TestHelper.arrayStringTo2DIntArray("[]")),
                        TestHelper.arrayStringTo2DIntArray("[]"));
    }
}