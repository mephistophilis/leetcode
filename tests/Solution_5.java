package tests;
//5. Longest Palindromic Substring

//https://leetcode.com/problems/longest-palindromic-substring/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
          
        boolean[][] dp = new boolean[n][n];
          
        for (int i = n - 1; i >= 0; i--) {
          for (int j = i; j < n; j++) {
            dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                  
            if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
              res = s.substring(i, j + 1);
            }
          }
        }
          
        return res;
    }

    @Test
    void test() {
        Assertions.assertEquals("bab",
                longestPalindrome("babad"));

    }
}