package tests;
//1091. Shortest Path in Binary Matrix

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int dir[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { -1, 1 }, { -1, -1 },
                { 1, 1 } };

        int r = grid.length;
        int c = grid[0].length;

        if (grid[0][0] == 1 || grid[r - 1][c - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pop = queue.remove();
                if (pop[0] == r - 1 && pop[1] == c - 1) {
                    return ans + 1;
                }
                for (int k = 0; k < 8; k++) {
                    int nextX = dir[k][0] + pop[0];
                    int nextY = dir[k][1] + pop[1];

                    if (nextX >= 0 && nextX < c && nextY >= 0 && nextY < r && !visited[nextY][nextX]
                            && grid[nextY][nextX] == 0) {
                        queue.add(new int[] { nextX, nextY });
                        visited[nextY][nextX] = true;
                    }

                }
            }
            ans++;
        }

        return -1;
    }

    @Test
    void test() {
        Assertions
                .assertEquals(
                        shortestPathBinaryMatrix(TestHelper.arrayStringTo2DIntArray("[[0,1],[1,0]]")), 2);

    }
}