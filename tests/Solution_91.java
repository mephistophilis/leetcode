package tests;
//91. Decode Ways

//https://leetcode.com/problems/arithmetic-slices/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_91 {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) != '0' ? 1 : 0;
    for (int i = 2; i <= n; i++) {
      int first = Integer.valueOf(s.substring(i - 1, i));
      int second = Integer.valueOf(s.substring(i - 2, i));
      if (first >= 1 && first <= 9) {
        dp[i] += dp[i - 1];
      }
      if (second >= 10 && second <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[n];
  }

  @Test
  void test() {
    Assertions.assertEquals(3,
        numDecodings("226"));
  }
}