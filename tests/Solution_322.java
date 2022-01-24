package tests;
//322. Coin Change

//https://leetcode.com/problems/coin-change/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_322 {

  public int coinChange(int[] coins, int amount) {
    if (amount < 1)
      return 0;
    int[] dp = new int[amount + 1];
    int sum = 0;

    while (++sum <= amount) {
      int min = -1;
      for (int coin : coins) {
        if (sum >= coin && dp[sum - coin] != -1) {
          int temp = dp[sum - coin] + 1;
          min = min < 0 ? temp : (temp < min ? temp : min);
        }
      }
      dp[sum] = min;
    }
    return dp[amount];
  }

  @Test
  void test() {
    Assertions.assertEquals(3,
        coinChange(TestHelper.arrayStringToIntArray("[1,2,5]"), 11));
  }
}