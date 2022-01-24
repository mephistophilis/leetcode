package tests;
//583. Delete Operation for Two Strings

//https://leetcode.com/problems/delete-operation-for-two-strings/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution_583 {

  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < word1.length(); ++i)
      for (int j = 0; j < word2.length(); ++j)
        if (word1.charAt(i) == word2.charAt(j))
          dp[i + 1][j + 1] = 1 + dp[i][j];
        else
          dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
    int val = dp[word1.length()][word2.length()];

    return word1.length() - val + word2.length() - val;
  }

  @Test
  void test() {
    Assertions.assertEquals(2,
        minDistance("sea", "eat"));
  }
}