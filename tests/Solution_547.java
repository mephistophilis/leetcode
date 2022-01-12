package tests;
//547. Number of Provinces

//https://leetcode.com/problems/number-of-provinces/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_547 {

    public void dfs(int[][] isConnected, int[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    @Test
    void test() {
        Assertions
                .assertEquals(2, findCircleNum(TestHelper.arrayStringTo2DIntArray(
                        "[[1,1,0],[1,1,0],[0,0,1]]")));

    }
}