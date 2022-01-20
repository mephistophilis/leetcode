package tests;
//62. Unique Paths

//https://leetcode.com/problems/unique-paths/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_62 {
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }
        return map[m - 1][n - 1];
    }

    @Test
    void test() {
        Assertions.assertEquals(28,
                uniquePaths(3, 7));
    }
}