package tests;
//673. Number of Longest Increasing Subsequence

//https://leetcode.com/problems/number-of-longest-increasing-subsequence/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_673 {

  public int findNumberOfLIS(int[] nums) {
    int n = nums.length, res = 0, max_len = 0;
    int[] len = new int[n], cnt = new int[n];
    for (int i = 0; i < n; i++) {
      len[i] = cnt[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (len[i] == len[j] + 1)
            cnt[i] += cnt[j];
          if (len[i] < len[j] + 1) {
            len[i] = len[j] + 1;
            cnt[i] = cnt[j];
          }
        }
      }
      if (max_len == len[i])
        res += cnt[i];
      if (max_len < len[i]) {
        max_len = len[i];
        res = cnt[i];
      }
    }
    return res;
  }

  @Test
  void test() {
    Assertions.assertEquals(2,
        findNumberOfLIS(TestHelper.arrayStringToIntArray("[1,3,5,4,7]")));
  }
}