package tests;
//300. Longest Increasing Subsequence

//https://leetcode.com/problems/longest-increasing-subsequence/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.common.TestHelper;

class Solution_300 {
  public static int findPositionToReplace(int[] a, int low, int high, int x) {
    int mid;
    while (low <= high) {
      mid = low + (high - low) / 2;
      if (a[mid] == x)
        return mid;
      else if (a[mid] > x)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return low;
  }

  public int lengthOfLIS(int[] nums) {
    if (nums == null | nums.length == 0)
      return 0;
    int n = nums.length, len = 0;
    int[] increasingSequence = new int[n];
    increasingSequence[len++] = nums[0];
    for (int i = 1; i < n; i++) {
      if (nums[i] > increasingSequence[len - 1])
        increasingSequence[len++] = nums[i];
      else {
        int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
        increasingSequence[position] = nums[i];
      }
    }
    return len;
  }

  @Test
  void test() {
    Assertions.assertEquals(4,
        lengthOfLIS(TestHelper.arrayStringToIntArray("[10,9,2,5,3,7,101,18]")));
    Assertions.assertEquals(1, lengthOfLIS(TestHelper.arrayStringToIntArray("[7,7,7,7,7,7,7]")));
  }
}